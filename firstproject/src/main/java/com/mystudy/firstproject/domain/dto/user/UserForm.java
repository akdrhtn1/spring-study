package com.mystudy.firstproject.domain.dto.user;

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
    private String username;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    private String passwd2;

    private String name;
    private String cellPhone;
    private String btDate;
    private String gender;
}
