package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.Room;
import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Transactional
public class RoomController {

    @Autowired
    RoomRepo roomRepo;

    @RequestMapping("/showRooms")
    public ModelAndView showAll(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        List<Room> rooms = roomRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));

        mav.setViewName("room/viewAll");

        if (rooms.isEmpty()) {


            mav.addObject("message", "Nie znaleźliśmy żadnego pacjenta");
            return mav;
        } else {
            mav.addObject("rooms", rooms);
            return mav;
        }

    }


    @RequestMapping("/addRoom")
    public ModelAndView addRoom(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("room/add");
        return mav;
    }
}
