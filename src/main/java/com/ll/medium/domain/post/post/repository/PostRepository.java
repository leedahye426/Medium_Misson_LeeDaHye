package com.ll.medium.domain.post.post.repository;

import com.ll.medium.domain.post.post.entiry.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByIsPublishedTrue();

    List<Post> findTop30ByIsPublishedTrueOrderByCreateDateDesc();

    List<Post> findByAuthorUsername(String username);

    Post findByAuthorUsernameAndId(String username, Integer id);
}
