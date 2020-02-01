package com.sanatorium.sanatorium.controllers;

import com.sanatorium.sanatorium.models.Visit;
import com.sanatorium.sanatorium.repo.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional
public class VisitController {

    @Autowired
    VisitRepo visitRepo;



}
