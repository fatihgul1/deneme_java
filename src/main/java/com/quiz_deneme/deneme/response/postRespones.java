package com.quiz_deneme.deneme.response;

import com.quiz_deneme.deneme.entities.Like;
import com.quiz_deneme.deneme.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class postRespones {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;




    public postRespones(Post entity) {
        this.id = entity.getId();
        this.userId= entity.getUser().getId();
        this.userName= entity.getUser().getUser_name();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}
