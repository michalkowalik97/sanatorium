package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.helpers.PermissionResolwer;
import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserRepo repo;

    @Autowired
    PermissionResolwer p;
    /**
     * Metoda zwracająca stronę logowania
     *
     * @return plik JSP ze stroną logowania
     */
    @RequestMapping("/login")
    public String index() {
        return "login";
    }


    /**
     * Metoda obsługująca logowanie
     *
     * @param req dane z formularza
     * @return Strona panelu lub błąd i powrót do strony logowania
     */
    @PostMapping("/userLogin")
    public ModelAndView login(HttpServletRequest req) {

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("passoword");
        req.getSession().setAttribute("user", "");

        ModelAndView mav = new ModelAndView();

        User user = repo.findUserByLogin(login);


        if (user != null) {
            if (password.equals(user.getPassword())) {
                req.getSession().setAttribute("user", login);
                req.getSession().setAttribute("perms", user.getPermId());

                mav.setViewName(p.selectHome(login));
                mav.addObject("message", "Witaj " + user.getName());
                return mav;


            }
            mav.setViewName("login");
            mav.addObject("error", "Błąd logowania");
            return mav;
        }

        mav.setViewName("login");
        mav.addObject("error", "Błąd logowania");
        return mav;


    }

    /**
     * Metoda służąca do wylogowania użytkownika
     * @param req - request
     * @return - Strona startowa
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().setAttribute("user", "");
        return "index";
    }

}
