package com.tcs.blogapp.articles.dtos;

import com.tcs.blogapp.users.UserEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreateArticleDto {
    String title;
    String content;
}
