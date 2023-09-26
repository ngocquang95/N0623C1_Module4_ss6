package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Clazz;

import java.util.List;

public interface IClazzRepository {
    List<Clazz> findAll();
}
