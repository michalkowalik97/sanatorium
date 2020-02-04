package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.helpers.PermissionResolwer;
import com.sanatorium.sanatorium.helpers.UpdateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    PermissionResolwer p;

    @Autowired
    UpdateHelper updateHelper;

    /**
     * Metoda zwracająca stronę startową
     * @return plik JSP zawierający odpowiedną stronę
     */
    @RequestMapping("/")
    public ModelAndView homePage(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();

        if (req.getSession().getAttribute("user") != "" ){
            updateHelper.refreshTurnuses();
            return p.selectHome((String) req.getSession().getAttribute("user"));
        }else {
            req.getSession().setAttribute("user","");
        }
        mav. setViewName("index");

        return mav;
    }
}
