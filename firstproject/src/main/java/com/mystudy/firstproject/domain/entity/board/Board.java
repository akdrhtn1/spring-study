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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Column(length=1000)
    private String content;
}
