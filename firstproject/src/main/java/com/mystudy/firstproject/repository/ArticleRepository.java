package com.mystudy.firstproject.repository;

import com.mystudy.firstproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}
