package com.quiz_deneme.deneme.services;

import com.quiz_deneme.deneme.entities.Like;
import com.quiz_deneme.deneme.entities.Post;
import com.quiz_deneme.deneme.entities.User;
import com.quiz_deneme.deneme.repository.LikeRepo;
import com.quiz_deneme.deneme.request.LikeCreateRequest;
import com.quiz_deneme.deneme.response.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {
    @Autowired
    LikeRepo likeRepo;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    public Like getOneLikeById(Long likeId) {
        return likeRepo.findById(likeId).orElse(null);
    }

    public List<LikeResponse> getAllLikeById(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if (userId.isPresent() && postId.isPresent()){
            list = likeRepo.findByUserIdAndPostId(userId,postId);
        }
        else if (userId.isPresent()){
            list = likeRepo.findByUserId(userId);
        }
        else if (postId.isPresent()) {
            list = likeRepo.findByPostId(postId);
        }
        else
            list = likeRepo.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    public Like createOnelike(LikeCreateRequest likeCreateRequest) {
        User user = userService.getOneUserById(likeCreateRequest.getUserId());
        Post post = postService.getOnePostById(likeCreateRequest.getPostId());
        if (user != null && post != null){
            Like likeToSave = new Like();
            likeToSave.setId(likeCreateRequest.getId());
            likeToSave.setUser(user);
            likeToSave.setPost(post.getUser());
            return likeRepo.save(likeToSave);
        }else
            return null;
    }

    public void deleteById(Long likeId) {
        likeRepo.deleteById(likeId);
    }
}
