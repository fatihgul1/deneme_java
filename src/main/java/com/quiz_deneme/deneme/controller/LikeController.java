package com.quiz_deneme.deneme.controller;

import com.quiz_deneme.deneme.entities.Like;
import com.quiz_deneme.deneme.repository.LikeRepo;
import com.quiz_deneme.deneme.request.LikeCreateRequest;
import com.quiz_deneme.deneme.response.LikeResponse;
import com.quiz_deneme.deneme.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    private LikeRepo likeRepo;

    @GetMapping
    public List<LikeResponse> getAllLike(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLikeById(userId,postId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.createOnelike(likeCreateRequest);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLikeById(@PathVariable Long likeId){
        likeService.deleteById(likeId);
    }
}
