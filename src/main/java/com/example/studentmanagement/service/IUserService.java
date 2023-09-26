package com.example.studentmanagement.service;

import com.example.studentmanagement.model.User;

public interface IUserService {
    User findByUsername(String username);
}
