package com.tcs.blogapp.articles;

import com.tcs.blogapp.articles.dtos.ArticleResponseDto;
import com.tcs.blogapp.articles.dtos.CreateArticleDto;
import com.tcs.blogapp.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @PostMapping("")
    private ResponseEntity<ArticleResponseDto> createArticle(@RequestBody CreateArticleDto articleDto){
        UserEntity owner = new UserEntity();
        return ResponseEntity.ok( articlesService.createArticle(articleDto, owner) );
    }
}
