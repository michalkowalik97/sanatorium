package com.sanatorium.sanatorium.controllers;


import com.sanatorium.sanatorium.models.Permission;
import com.sanatorium.sanatorium.models.Room;
import com.sanatorium.sanatorium.models.Turnus;
import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.PermissionRepo;
import com.sanatorium.sanatorium.repo.RoomRepo;
import com.sanatorium.sanatorium.repo.TurnusRepo;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Transactional
public class TurnusesController {

    @Autowired
    TurnusRepo turnusRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    PermissionRepo permRepo;

    @RequestMapping("/showTurnuses")
    public ModelAndView showAll(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("turnus/viewAll");

        List<Turnus> turnuses = turnusRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));

        if (turnuses.isEmpty()) {
            mav.addObject("message", "Nie znaleźliśmy żadnego pobytu.");

        } else {
            mav.addObject("turnuses", turnuses);

        }

        return mav;
    }

    @RequestMapping("/addTurnus")
    public ModelAndView addTurnus(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("turnus/add");
        List<User> patients = userRepo.findUsersByPermissionName("patient");
        List<Room> rooms = roomRepo.findRoomsByStateOrderByIdAsc("wolny");//roomRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
        mav.addObject("patients", patients);
        mav.addObject("rooms", rooms);


        return mav;
    }

    @PostMapping("/saveTurnus")
    public ModelAndView saveTurnus(HttpServletRequest req) {

        String referer = req.getHeader("Referer");
        User patient = null;
        try {
            ModelAndView mav = new ModelAndView();
            String checkbox = (req.getParameter("newPatient"));
            Turnus turnus = new Turnus();

            System.out.println(req.getParameter("dateStart"));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {

                //  System.out.println("date from string:" + date.toString());
                turnus.setFromDateTime(dateFormat.parse(req.getParameter("dateStart")));
                turnus.setToDateTime(dateFormat.parse(req.getParameter("dateEnd")));

                System.out.println(turnus.getFromDateTime().toString());
            } catch (Exception e) {
                return new ModelAndView("redirect:" + referer, "error", "Nie udało się dodać pobytu, nie wybrano daty!");
            }

            Room room = roomRepo.findRoomById(Long.parseLong(req.getParameter("room")));
            turnus.setRoom(room);

            turnus.setActive(true);


            if (checkbox == null) {
                patient = userRepo.findUserById(Long.parseLong(req.getParameter("patient")));
                turnus.setPatient(patient);

            } else {
                patient = new User();

                patient.setName(req.getParameter("name"));
                patient.setSurname(req.getParameter("surname"));
                patient.setPermission(permRepo.findPermissionByName("patient"));
                patient.setPassword("zaq1@WSX");

                String login = req.getParameter("name").substring(0, 1) + "." + req.getParameter("surname");
                login = login.toLowerCase();
                if (userRepo.findUserByLogin(login) == null) {
                    patient.setLogin(login);
                } else {
                    int i = 2;
                    String baseLogin = new String(login);
                    while (true) {
                        login = baseLogin + String.valueOf(i);
                        if (userRepo.findUserByLogin(login) == null) {
                            patient.setLogin(login);
                            break;
                        }

                        i++;
                    }

                }


                userRepo.save(patient);
                turnus.setPatient(patient);

            }

            turnusRepo.save(turnus);
            room.setState("zajety");
            roomRepo.save(room);
            return new ModelAndView("redirect:/showTurnuses", "message", "Podbyt dodany. Pacjent: " + patient.getLogin());


        } catch (Exception e) {

            return new ModelAndView("redirect:" + referer, "error", "Nie udało się dodać pobytu!");
        }

    }

}
