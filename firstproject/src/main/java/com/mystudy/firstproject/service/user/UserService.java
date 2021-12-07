package com.mystudy.firstproject.service.user;

import com.mystudy.firstproject.domain.entity.user.Member;
import com.mystudy.firstproject.repository.user.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String join(Member member){
        Member save = userRepository.save(member);
        return save.getId();
    }
    public Optional<Member> findByList(String id) {
        Optional<Member> option = userRepository.findById(id);
        return option;
    }

    public Member findByName(String name){
        Member member = userRepository.findByName(name);

        return member;
    }
    public Optional<Member> login(String id, String passwd){
        Optional<Member> member = userRepository.findByIdAndPasswd(id,passwd);

        return member;
    }

}
