package com.example.socialmedia.Controllers;

import com.example.socialmedia.Entity.Post;
import com.example.socialmedia.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestParam Long userId, @RequestParam String title, @RequestParam String body) {
        Post post = postService.addPost(userId, title, body);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<Post>> listUserPosts(@PathVariable Long userId, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postService.listUserPosts(userId, pageable);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/top")
    public ResponseEntity<Page<Object[]>> listTopPosts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Object[]> posts = postService.listTopPosts(pageable);
        return ResponseEntity.ok(posts);
    }
}
