package com.quiz_deneme.deneme.request;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    Long postId;
    Long userId;
    String text;
}
