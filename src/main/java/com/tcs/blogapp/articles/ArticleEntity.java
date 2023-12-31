package com.tcs.blogapp.articles;

import com.tcs.blogapp.comments.CommentEntity;
import com.tcs.blogapp.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "article")
    private List<CommentEntity> comments;
}
