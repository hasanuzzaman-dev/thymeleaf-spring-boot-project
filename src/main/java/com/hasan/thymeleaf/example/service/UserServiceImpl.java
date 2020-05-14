package com.hasan.thymeleaf.example.service;

import com.hasan.thymeleaf.example.entity.User;
import com.hasan.thymeleaf.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> listAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> listUsersWithDisplayName(String displayName, Pageable pageable) {
        return userRepository.findAllByDisplayName(displayName, pageable);
    }

    @Override
    public Page<User> listUsersWithFirstNameOrLastName(String name, Pageable pageable) {
        return userRepository.findAllByFirstNameOrLastName(name, name, pageable);
    }

}
