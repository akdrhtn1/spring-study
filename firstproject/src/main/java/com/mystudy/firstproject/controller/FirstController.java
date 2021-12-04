package com.mystudy.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/")
    public String greeting(Model model){

        model.addAttribute("name","park");
        return "grettings";
    }

    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("nickname","hong");
        return "goodbye";
    }
}
