package com.mystudy.firstproject.domain.dto.board;


import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class BoardForm {
    private String name;
    private String email;
    private String email2;
    private String phone;
    private String user_type;
    private String any_type;
    private String title;
    private String content;
}
