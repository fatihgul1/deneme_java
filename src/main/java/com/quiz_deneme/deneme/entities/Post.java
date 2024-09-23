package com.quiz_deneme.deneme.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    String title;

    @Column(columnDefinition = "text")
    String text;


}
