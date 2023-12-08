package com.ll.medium.domain.post.post.entiry;

import com.ll.medium.domain.member.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String body;

    private boolean isPublished;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ManyToOne
    private Member author;
}
