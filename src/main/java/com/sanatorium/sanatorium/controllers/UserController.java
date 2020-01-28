package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.Permission;
import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.PermissionRepo;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepo repo;

    @Autowired
    PermissionRepo permRepo;


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

    @RequestMapping("/addUser")
    public ModelAndView addUser(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();

        List<Permission> permissions = permRepo.findAll();
        mav.setViewName("users/add");
        mav.addObject("permissions", permissions);
        return mav;
    }

    @PostMapping("/saveUser")
    public ModelAndView store(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        int permId = Integer.parseInt(req.getParameter("role"));
        Permission permission = permRepo.findPermissionById(permId);


        User user = new User();
        // user.setId(1);
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword("zaq1@WSX");
        user.setPermission(permission);

        for (int i = 0; i < 10; i++) {
            try {

                repo.save(user);

            } catch (Exception e) {
                continue;
            }
            break;
        }

        // mav.setViewName("users/viewAll");
       // mav.addObject("message", "Użytkownik dodany pomyślnie");

        return new ModelAndView("redirect:/showUsers","message", "Użytkownik dodany pomyślnie");
        //return new ModelAndView();
    }
}
