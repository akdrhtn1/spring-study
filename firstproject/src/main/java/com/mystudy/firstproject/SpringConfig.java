package com.mystudy.firstproject;

import com.mystudy.firstproject.repository.ArticleRepository;
import com.mystudy.firstproject.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final ArticleRepository articleRepository;

    @Autowired
    public SpringConfig(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Bean
    public ArticleService articleService(){
        return new ArticleService(articleRepository);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    //MemberRepository도 Annotation 안쓰고 할려면 원래 써야하지만 !! interface를 상속받아서 주입하므로 @Bean을 안써도 됨
}
