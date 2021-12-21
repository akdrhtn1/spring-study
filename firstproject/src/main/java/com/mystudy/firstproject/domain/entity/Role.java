package com.mystudy.firstproject.domain.entity;


import com.mystudy.firstproject.domain.entity.user.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private long id;
    private String name;

    @ManyToMany(mappedBy = "roles") //Member 테이블에 있는 컬럼이름
    private List<Member> members;
}
