package com.mystudy.firstproject.domain.entity.board;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Setter
public class Board {
    @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long idx;
    private String name;
    private String email;
    private String email2;
    private String phone;
    private String user_type;
    private String any_type;
    private String title;
    @Column(length=1000)
    private String content;
}
