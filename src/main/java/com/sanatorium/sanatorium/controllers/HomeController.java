package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.helpers.PermissionResolwer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    PermissionResolwer p;
    /**
     * Metoda zwracająca stronę startową
     * @return plik JSP zawierający odpowiedną stronę
     */
    @RequestMapping("/")
    public String homePage(HttpServletRequest req){

        if (req.getSession().getAttribute("user") != "" ){

            return p.selectHome((String) req.getSession().getAttribute("user"));
        }else {
            req.getSession().setAttribute("user","");
        }

        return "index";
    }
}
