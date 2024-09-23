package com.quiz_deneme.deneme.repository;

import com.quiz_deneme.deneme.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepo extends JpaRepository<Like,Long> {

    List<Like> findByUserIdAndPostId(Optional<Long> userId, Optional<Long> postId);

    List<Like> findByUserId(Optional<Long> userId);

    List<Like> findByPostId(Optional<Long> postId);
}
