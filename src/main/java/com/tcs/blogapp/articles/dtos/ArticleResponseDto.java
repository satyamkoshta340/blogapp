package com.tcs.blogapp.articles.dtos;

import com.tcs.blogapp.users.UserEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleResponseDto {
    String title;
    String content;
    Date publishDate;
    UserEntity owner;
}
