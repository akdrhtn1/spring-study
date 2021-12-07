package com.mystudy.firstproject.controller.user;

import com.mystudy.firstproject.domain.entity.user.Member;
import com.mystudy.firstproject.domain.dto.user.UserForm;
import com.mystudy.firstproject.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/userCreate")
    public String userCreate(UserForm form){

        log.info(form.toString());

        Member member = modelMapper.map(form, Member.class);
        member.setPasswd(form.getPaswd1());
        String userId = userService.join(member);

        log.info(userId);
        Member Memname = userService.findByName(member.getName());

        log.info(Memname.toString());


        return "redirect:/";
    }

}
