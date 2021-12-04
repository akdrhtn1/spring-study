package com.mystudy.firstproject.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class UserForm {
    private String id;
    private String paswd1;
    private String paswd2;
    private String name;
    private String cellPhone;
    private String btDate;
    private String gender;
}
