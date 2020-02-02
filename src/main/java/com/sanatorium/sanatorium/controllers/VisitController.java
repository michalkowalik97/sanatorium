package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.models.Visit;
import com.sanatorium.sanatorium.repo.UserRepo;
import com.sanatorium.sanatorium.repo.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@Transactional
public class VisitController {

    @Autowired
    VisitRepo visitRepo;

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/addVisit")
    public ModelAndView addVisit(HttpServletRequest req) {

        ModelAndView mav = new ModelAndView();

        try {
            String currUser = (String) req.getSession(false).getAttribute("user");

            User user = userRepo.findUserByLogin(currUser);

            List<User> doctors = null;
            if (user.getPermission().getName().equals("doctor")) {
                doctors = new LinkedList<User>();
                doctors.add(user);

            } else {
                doctors = userRepo.findUsersByPermissionName("doctor");
            }

            List<User> patients = userRepo.findUsersByPermissionName("patient");

            if (doctors != null && patients != null) {

                mav.addObject("doctors", doctors);
                mav.addObject("patients", patients);

                mav.setViewName("visit/add");

                return mav;
            }
        } catch (Exception e) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveVisit")
    public ModelAndView saveVisit(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String referer = req.getHeader("Referer");


        Visit visit = new Visit();
        Long doctorId = Long.parseLong(req.getParameter("doctor"));
        Long patientId = Long.parseLong(req.getParameter("patient"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm");
        try {
            Date date = dateFormat.parse(req.getParameter("date"));

            visit.setDoctor(userRepo.findUserById(doctorId));
            visit.setPatient(userRepo.findUserById(patientId));
            visit.setDateTime(date);
            visit.setActive(true);
            visitRepo.save(visit);

            return new ModelAndView("redirect:/showVisits", "message", "Wizyta dodana pomyślnie.");

        } catch (Exception e) {
            return new ModelAndView("redirect:" + referer, "error", "Nie udało się dodać wizyty!");
        }

    }


    @RequestMapping("/showVisits")
    public ModelAndView showVisits(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        List<Visit> visits = visitRepo.findAll(Sort.by(Sort.Direction.ASC,"dateTime"));
        mav.setViewName("visit/viewAll");
        if (visits != null){


            mav.addObject("visits", visits);
            return mav;

        }

        mav.addObject("message", "Nie znaleźliśmy żadnej wizyty.");
        return mav;

    }


    @RequestMapping("/editVisit/{id}")
    public ModelAndView editVisit(@PathVariable("id") Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        Visit visit = visitRepo.findVisitById(id);

        List<User> doctors = userRepo.findUsersByPermissionName("doctor");
        List<User> patients = userRepo.findUsersByPermissionName("patient");


        if (visit != null && doctors != null && patients != null){
            mav.addObject("visit", visit);
            mav.addObject("doctors", doctors);
            mav.addObject("patients", patients);
            mav.setViewName("visit/edit");
            return mav;
        }

        String referer = req.getHeader("Referer");

        return new ModelAndView("redirect:" + referer, "error", "Nie znaleziono wizyty!");

    }

    @PostMapping("/editVisit/{id}")
    public ModelAndView updateVisit(@PathVariable("id") Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        String referer = req.getHeader("Referer");


        Visit visit = visitRepo.findVisitById(id);
        if (visit != null){
        Long doctorId = Long.parseLong(req.getParameter("doctor"));
        Long patientId = Long.parseLong(req.getParameter("patient"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm");
        try {
            Date date = dateFormat.parse(req.getParameter("date"));

            visit.setDoctor(userRepo.findUserById(doctorId));
            visit.setPatient(userRepo.findUserById(patientId));
            visit.setDateTime(date);
            visitRepo.save(visit);

            return new ModelAndView("redirect:/showVisits", "message", "Wizyta zaktualizowana pomyślnie.");

        } catch (Exception e) {
            return new ModelAndView("redirect:" + referer, "error", "Nie udało się zaktualizować wizyty!");
        }
        }

        return new ModelAndView("redirect:" + referer, "error", "Nie udało się zaktualizować wizyty!");
    }


    @RequestMapping("/deleteVisit/{id}")
    public ModelAndView deleteVisit(@PathVariable("id") Long id){

        try{
            visitRepo.removeVisitById(id);
        }catch (Exception e){
            return new ModelAndView("redirect:/showVisits", "error", "Błąd podczas usuwania");

        }
        return new ModelAndView("redirect:/showVisits", "message", "Wizyta usunięta pomyślnie");

    }
}
