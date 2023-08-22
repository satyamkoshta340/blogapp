package com.tcs.blogapp.comments;

import com.tcs.blogapp.articles.ArticleEntity;
import com.tcs.blogapp.users.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date timestamp;
}
