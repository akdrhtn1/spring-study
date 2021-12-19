package com.mystudy.firstproject.domain.entity.user;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter @Setter
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    private String passwd;
    private String name;
    private boolean enabled;
    private String cellPhone;
    private String btDate;
    private String gender;
}
