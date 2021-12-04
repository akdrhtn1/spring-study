package com.mystudy.firstproject.dto;

import com.mystudy.firstproject.domain.Article;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class ArticleForm {

    private String title;
    private String content;



}
