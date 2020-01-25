package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserRepo repo;

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
    public String login(HttpServletRequest req) {

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("passoword");

        User user = repo.findUserByTheBestParameter(login);

        if (  password.equals(user.getPassword())){
            req.getSession().setAttribute("user", login);
            return "home";
        }else {
            return "login";
        }
    }

}
