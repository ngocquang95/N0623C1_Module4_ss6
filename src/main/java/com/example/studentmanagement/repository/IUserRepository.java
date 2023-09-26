package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.User;

public interface IUserRepository {
    User findByUsername(String username);
}
