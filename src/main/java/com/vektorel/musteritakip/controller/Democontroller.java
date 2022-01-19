package com.vektorel.musteritakip.controller;

import com.vektorel.musteritakip.repository.entity.Category;
import com.vektorel.musteritakip.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Democontroller {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public void Kategori(){
        categoryService.save(
                Category.builder()
                        .ad("Bilgisayar")
                        .parentid(0L)
                        .url("/bilgisayar")
                        .build()
        );
        categoryService.save(
                Category.builder()
                        .ad("Beyazeşya ")
                        .parentid(0L)
                        .url("/beyazesya")
                        .build()
        );
        categoryService.save(
                Category.builder()
                        .ad("Mobilya")
                        .parentid(0L)
                        .url("/mobilya")
                        .build()
        );
    }
}
