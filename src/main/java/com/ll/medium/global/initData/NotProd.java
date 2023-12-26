package com.ll.medium.global.initData;

import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {

//    @Bean
//    public ApplicationRunner initNotProd(PostService postService, MemberService memberService) {
//        return args -> {
//            Member member1 = memberService.create("user1",  "1234");
//            Member member2 = memberService.create("user2",  "1234");
//
//            for(int i = 1; i <= 50; i++) {
//                String title = "%d번 공개 게시글 데이터 입니다.".formatted(i);
//                String body = "%d번 공개 내용 데이터 입니다. ".formatted(i);
//                String isPublished = "true";
//                PostForm postForm = new PostForm(title, body, isPublished);
//                postService.save(postForm, member1);
//            }
//            for(int i = 1; i <= 50; i++) {
//                String title = "%d번 비공개 게시글 데이터 입니다.".formatted(i);
//                String body = "%d번 비공개 내용 데이터 입니다. ".formatted(i);
//                String isPublished = "false";
//                PostForm postForm = new PostForm(title, body, isPublished);
//                postService.save(postForm, member2);
//            }
//
//        };
//    }
}

