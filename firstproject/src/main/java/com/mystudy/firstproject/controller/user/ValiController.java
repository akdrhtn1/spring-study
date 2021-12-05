package com.mystudy.firstproject.controller.user;

import com.mystudy.firstproject.domain.user.Member;
import com.mystudy.firstproject.dto.user.UserForm;
import com.mystudy.firstproject.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class ValiController {

    private UserService userService;

    @Autowired
    public ValiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/idCheck")
    public Optional<Member> idCheck(@RequestBody UserForm form){
        log.info(form.toString());
        Optional<Member> memb  = userService.findByList(form.getId());
        return memb;
    }
}
