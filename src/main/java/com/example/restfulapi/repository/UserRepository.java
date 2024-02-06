package com.example.restfulapi.repository;

import com.example.restfulapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User deleteById(User user);

}
