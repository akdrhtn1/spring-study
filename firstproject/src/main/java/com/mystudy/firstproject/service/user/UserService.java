package com.mystudy.firstproject.service.user;

import com.mystudy.firstproject.domain.entity.Role;
import com.mystudy.firstproject.domain.entity.user.Member;
import com.mystudy.firstproject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(Member member){
        String encodedPassword = passwordEncoder.encode(member.getPassword()); //비밀번호를 암호화
        member.setPassword(encodedPassword);
        member.setEnabled(true);

        Role role = new Role();
        role.setId(1l);

        member.getRoles().add(role);
        Member save = userRepository.save(member);
        return save.getUsername();
    }
    public Optional<Member> findByList(String id) {
        Optional<Member> option = userRepository.findById(id);
        return option;
    }

    public Member findByName(String name){
        Member member = userRepository.findByName(name);

        return member;
    }
    public Optional<Member> login(String id, String password){
        Optional<Member> member = userRepository.findByIdAndPassword(id,password);

        return member;
    }

}
