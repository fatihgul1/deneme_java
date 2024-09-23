package com.quiz_deneme.deneme.repository;

import com.quiz_deneme.deneme.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Optional<Long> userId);
}
