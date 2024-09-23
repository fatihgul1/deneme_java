package com.quiz_deneme.deneme.repository;

import com.quiz_deneme.deneme.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
