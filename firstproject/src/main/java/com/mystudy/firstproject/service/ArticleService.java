package com.mystudy.firstproject.service;

import com.mystudy.firstproject.domain.Article;
import com.mystudy.firstproject.repository.ArticleRepository;

public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Long join(Article article){
        Article saved = articleRepository.save(article);

        return article.getId();
    }
}
