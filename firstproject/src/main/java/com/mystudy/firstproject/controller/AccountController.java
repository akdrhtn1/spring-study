package com.mystudy.firstproject.controller;

import com.mystudy.firstproject.domain.dto.user.UserForm;
import com.mystudy.firstproject.domain.entity.user.Member;
import com.mystudy.firstproject.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public AccountController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }


    @GetMapping("/register")
    public String register(){
        return "account/register";
    }

    @PostMapping("/register")
    public String resister(UserForm userForm){
        Member member = modelMapper.map(userForm, Member.class);
        userService.join(member);
        return "redirect:/";
    }


}
