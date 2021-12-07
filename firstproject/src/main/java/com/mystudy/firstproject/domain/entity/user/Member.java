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
    private String id;
    @Column
    private String passwd;
    private String name;
    private String cellPhone;
    private String btDate;
    private String gender;
}
