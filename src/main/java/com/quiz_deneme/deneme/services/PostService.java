package com.quiz_deneme.deneme.services;
import com.quiz_deneme.deneme.entities.Post;
import com.quiz_deneme.deneme.entities.User;
import com.quiz_deneme.deneme.repository.PostRepo;
import com.quiz_deneme.deneme.request.PostCreateRequest;
import com.quiz_deneme.deneme.request.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserService userService;

    public List<Post> getAllPosts(Optional<Long> userId) {

        if(userId.isPresent()){
          return postRepo.findByUserId(userId);
        }
        else{
           return postRepo.findAll();
        }
    }

    public Post getOnePostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUserById(newPostRequest.getUserId());
        if (user == null)
            return null;

        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepo.save(toSave);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepo.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepo.deleteById(postId);
    }
}
