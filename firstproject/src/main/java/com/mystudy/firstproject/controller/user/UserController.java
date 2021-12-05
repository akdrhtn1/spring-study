package com.mystudy.firstproject.controller.user;

import com.mystudy.firstproject.domain.user.Member;
import com.mystudy.firstproject.dto.user.UserForm;
import com.mystudy.firstproject.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/resister")
    public String resister(){

        return "resister";
    }

    @PostMapping("/userCreate")
    public String userCreate(UserForm form){

        log.info(form.toString());

        Member member = modelMapper.map(form, Member.class);

        String userId = userService.join(member);

        log.info(userId);
        return "redirect:/";
    }

}
