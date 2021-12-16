package com.mystudy.firstproject.domain.dto.board;


import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class BoardForm {
    private long id;
    @NotNull
    @Size(min = 5,max = 30, message = "제목은 5자이상 30자 이하입니다. ")
    private String title;
    private String content;
}
