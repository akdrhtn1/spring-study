package com.mystudy.firstproject.repository.user;

import com.mystudy.firstproject.domain.entity.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member,String> {

    @Override
    Optional<Member> findById(String s);
    Member findByName(String name);
    Optional<Member> findByIdAndPasswd(String id, String passwd);
}
