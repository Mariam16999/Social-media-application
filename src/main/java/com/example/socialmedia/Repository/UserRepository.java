package com.example.socialmedia.Repository;

import com.example.socialmedia.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
