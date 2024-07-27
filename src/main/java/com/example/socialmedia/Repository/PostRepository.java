package com.example.socialmedia.Repository;

import com.example.socialmedia.Entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUserId(Long userId, Pageable pageable);

    @Query("SELECT r.post.id, AVG(r.rating) as avgRating FROM Review r GROUP BY r.post.id ORDER BY avgRating DESC")
    Page<Object[]> findTopRatedPosts(Pageable pageable);
}