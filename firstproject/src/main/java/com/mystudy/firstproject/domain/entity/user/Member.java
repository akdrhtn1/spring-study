package com.mystudy.firstproject.domain.entity.user;

import com.mystudy.firstproject.domain.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter @Setter
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String username;
    private String password;
    private String name;
    private boolean enabled;
    private String cellPhone;
    private String btDate;
    private String gender;

    @ManyToMany
    @JoinTable(name = "user_role", //조인테이블명
            joinColumns = @JoinColumn(name="user_id"),  //외래키
            inverseJoinColumns = @JoinColumn(name="role_id") //반대 엔티티의 외래키
    )
    private List<Role> roles = new ArrayList<>(); //null이 아닌값을 받기위해 생성
}
