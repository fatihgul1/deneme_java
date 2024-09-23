package com.quiz_deneme.deneme.services;

import com.quiz_deneme.deneme.entities.Comment;
import com.quiz_deneme.deneme.entities.Post;
import com.quiz_deneme.deneme.entities.User;
import com.quiz_deneme.deneme.repository.CommentRepo;
import com.quiz_deneme.deneme.request.CommentCreateRequest;
import com.quiz_deneme.deneme.request.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return commentRepo.findByUserIdAndPostId(userId.get(),postId.get());
        }
        else if (userId.isPresent()) {
            return commentRepo.findByUserId(userId.get());
        }
        else if (postId.isPresent()) {
            return commentRepo.findByPostId(postId.get());
        }
        else
            return commentRepo.findAll();

    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepo.findById(commentId).orElse(null);

    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
       User user = userService.getOneUserById(commentCreateRequest.getUserId());
       Post post = postService.getOnePostById(commentCreateRequest.getPostId());
        if (user != null && post != null){
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateRequest.getId());
            commentToSave.setUser(user);
            commentToSave.setPost(post.getUser());
            commentToSave.setText(commentCreateRequest.getText());
            return commentRepo.save(commentToSave);
        }else
            return null;
    }

    public Comment updateCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepo.findById(commentId);
        if (comment.isPresent()){
            Comment updateComment = comment.get();
            updateComment.setText(request.getText());
            return commentRepo.save(updateComment);
        }else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}
