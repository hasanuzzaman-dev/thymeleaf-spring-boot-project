package com.hasan.thymeleaf.example.service;

import com.hasan.thymeleaf.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> listAllUsers(Pageable pageable);

    Page<User> listUsersWithDisplayName(String displayName, Pageable pageable);

    Page<User> listUsersWithFirstNameOrLastName(String name, Pageable pageable);

}
