package com.hasan.thymeleaf.example.repository;

import com.hasan.thymeleaf.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByDisplayName(String displayName, Pageable pageable);

    Page<User> findAllByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);

}
