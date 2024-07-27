package com.example.socialmedia.Service;

import com.example.socialmedia.Entity.Post;
import com.example.socialmedia.Entity.Review;
import com.example.socialmedia.Entity.User;
import com.example.socialmedia.Repository.PostRepository;
import com.example.socialmedia.Repository.ReviewRepository;
import com.example.socialmedia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Review addReview(Long postId, Long userId, int rating, String comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Review review = new Review();
        review.setPost(post);
        review.setUser(user);
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}
