package com.mystudy.firstproject.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/resister")
    public String resister(){

        return "resister";
    }
}
