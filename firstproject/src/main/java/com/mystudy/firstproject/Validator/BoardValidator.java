package com.mystudy.firstproject.Validator;

import com.mystudy.firstproject.domain.dto.board.BoardForm;
import com.mystudy.firstproject.domain.entity.board.Board;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BoardForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BoardForm b = (BoardForm) obj;
        if(StringUtils.isEmpty(b.getContent())){
            errors.rejectValue("content","key","내용을 입력하세요");
        }

    }
}
