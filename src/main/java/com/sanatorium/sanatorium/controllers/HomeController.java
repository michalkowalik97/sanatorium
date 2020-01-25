package com.sanatorium.sanatorium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * Metoda zwracająca stronę startową
     * @return plik JSP zawierający odpowiedną stronę
     */
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
