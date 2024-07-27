package com.example.socialmedia.Service;

import com.example.socialmedia.Entity.Post;
import com.example.socialmedia.Entity.User;
import com.example.socialmedia.Repository.PostRepository;
import com.example.socialmedia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService{
    @Autowired
private PostRepository postRepository;

        @Autowired
        private UserRepository userRepository;

        public Post addPost(Long userId, String title, String body) {
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            Post post = new Post();
            post.setTitle(title);
            post.setBody(body);
            post.setCreatedAt(LocalDateTime.now());
            post.setUser(user);
            return postRepository.save(post);
        }

        public Page<Post> listUserPosts(Long userId, Pageable pageable) {
            return postRepository.findByUserId(userId, pageable);
        }

        public Page<Object[]> listTopPosts(Pageable pageable) {
            return postRepository.findTopRatedPosts(pageable);
        }
}
