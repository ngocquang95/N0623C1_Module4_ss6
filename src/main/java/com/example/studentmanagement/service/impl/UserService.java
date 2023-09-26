package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.model.User;
import com.example.studentmanagement.repository.IUserRepository;
import com.example.studentmanagement.repository.impl.UserRepository;
import com.example.studentmanagement.service.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
