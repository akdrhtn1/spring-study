package com.mystudy.firstproject.dto.user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class UserForm {

    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10 이하로 입력해주세요")
    private String id;
    @NotBlank(message = "이메일 주소를 입력해주세")
    private String paswd1;
    private String paswd2;
    private String name;

    private String cellPhone;
    private String btDate;
    private String gender;
}
