package com.vektorel.musteritakip.controllermodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Homecontroller {

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
