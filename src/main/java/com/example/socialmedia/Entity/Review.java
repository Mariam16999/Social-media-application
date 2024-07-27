package com.example.socialmedia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
