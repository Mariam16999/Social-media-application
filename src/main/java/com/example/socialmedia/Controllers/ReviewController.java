package com.example.socialmedia.Controllers;

import com.example.socialmedia.Entity.Review;
import com.example.socialmedia.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestParam Long postId, @RequestParam Long userId, @RequestParam int rating, @RequestParam String comment) {
        Review review = reviewService.addReview(postId, userId, rating, comment);
        return ResponseEntity.ok(review);
    }
}
