package com.quiz_deneme.deneme.controller;

import com.quiz_deneme.deneme.entities.Comment;
import com.quiz_deneme.deneme.repository.CommentRepo;
import com.quiz_deneme.deneme.request.CommentCreateRequest;
import com.quiz_deneme.deneme.request.CommentUpdateRequest;
import com.quiz_deneme.deneme.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllComments(userId,postId);
    }

    @PostMapping
    public Comment addOneComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createOneComment(commentCreateRequest);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateCommentById(commentId,request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
        System.out.println("deleted");
    }

}
