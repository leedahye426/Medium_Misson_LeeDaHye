package com.ll.medium.domain.post.post.entiry;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostForm {
    @NotBlank(message = "제목은 필수항목입니다.")
    private String title;

    @NotBlank(message = "내용은 필수항목입니다.")
    private String body;

    private String isPublished;
}
