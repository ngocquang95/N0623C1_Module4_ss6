package com.example.studentmanagement.repository.impl;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.model.User;
import com.example.studentmanagement.repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "select id, username, password from user where username = ?"
            );

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
