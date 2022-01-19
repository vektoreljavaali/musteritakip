package com.vektorel.musteritakip.controllermodel;

import com.vektorel.musteritakip.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Homecontroller {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        model.addObject("categorylist",
                categoryService.findByParentId(0));
        model.setViewName("index");
        return model;
    }


}
