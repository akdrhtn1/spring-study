package com.mystudy.firstproject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter @Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 1,2,3, ... 자동 생성 어노테이션!
    private Long id;
    @Column
    private String title;

    @Column
    private String content;


}