package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepo repo;

    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest req) {

        return "formTemplate";
    }

    @RequestMapping("/showUsers")
    public ModelAndView showAll(HttpServletRequest req) {

        List<User> users = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        ModelAndView mav = new ModelAndView();



        if (users != null && !users.isEmpty()) {
            mav.setViewName("users/viewAll");
            mav.addObject("users", users);
            return mav;
        }
      


        mav.setViewName("users/viewAll");
        mav.addObject("message", "Nie znaleźliśmy żadnego użytkownika");
        return mav;
    }
}
