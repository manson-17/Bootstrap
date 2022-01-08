package com.example.bootstrap.repository;

import com.example.bootstrap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
    User findUserById(Long id);
    User findUserByEmail(String email);
}
