package com.ll.medium.domain.post.post.service;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.post.post.entiry.Post;
import com.ll.medium.domain.post.post.entiry.PostForm;
import com.ll.medium.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(PostForm postForm, Member author) {
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setBody(postForm.getBody());
        if(postForm.getIsPublished().equals("true")) post.setPublished(true);
        else post.setPublished(false);
        post.setCreateDate(LocalDateTime.now());
        post.setAuthor(author);

        postRepository.save(post);
    }

    public Post getPost(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()) throw new RuntimeException();
        return post.get();
    }

    public List<Post> getPublished() {
        return postRepository.findByIsPublishedTrue();
    }

    public List<Post> getRecentPosts() {
        return postRepository.findTop30ByIsPublishedTrueOrderByCreateDateDesc();
    }

    public List<Post> getPostGroupByMember(String username) {
        return postRepository.findByAuthorUsername(username);
    }

    public Post getPost(String username, Integer id) {
        return postRepository.findByAuthorUsernameAndId(username, id);
    }

    public List<Post> getPostByUsername(String username) {
        return postRepository.findByAuthorUsername(username);
    }

    public void modify(Post post, PostForm postForm) {
        post.setTitle(postForm.getTitle());
        post.setBody(postForm.getBody());
        post.setModifyDate(LocalDateTime.now());
        if(postForm.getIsPublished().equals("true")) post.setPublished(true);
        else post.setPublished(false);

        postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
