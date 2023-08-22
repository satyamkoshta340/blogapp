package com.tcs.blogapp.articles;

import com.tcs.blogapp.articles.dtos.ArticleResponseDto;
import com.tcs.blogapp.articles.dtos.CreateArticleDto;
import com.tcs.blogapp.users.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticlesService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ArticlesRepository articlesRepository;

    public ArticleResponseDto createArticle(CreateArticleDto articleDto, UserEntity owner){
        ArticleEntity article = modelMapper.map(articleDto, ArticleEntity.class);
        article.setPublishDate(new Date());
        article.setOwner(owner);
        ArticleEntity savedArticle =  articlesRepository.save(article);
        return modelMapper.map(savedArticle, ArticleResponseDto.class);
    }
}
