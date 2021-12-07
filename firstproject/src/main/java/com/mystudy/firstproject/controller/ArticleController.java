package com.mystudy.firstproject.controller;

import com.mystudy.firstproject.domain.dto.ArticleForm;
import com.mystudy.firstproject.domain.Article;
import com.mystudy.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j  //로깅을 위한 어노테이션
public class ArticleController {

     // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleService articleService;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/new")
    public String newArticleForm(){
        return "article/new";
    }

    @PostMapping("/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        //  System.out.println(form.toString()); ->로길 기능으로 대체!!

        //1. Dto를 변환 Entity!!
        //  Article article = form.toEntity();

        //Article article = new Article(null,form.getTitle(),form.getContent());
        Article article = modelMapper.map(form,Article.class);

        //3. service 에서 검사 및 저장 처리
        log.info(article.toString());
        long id = articleService.join(article);

        log.info(String.valueOf(id));

        return "redirect:/";
    }
}
