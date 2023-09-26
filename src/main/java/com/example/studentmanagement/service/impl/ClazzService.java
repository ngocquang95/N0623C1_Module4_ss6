package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.model.Clazz;
import com.example.studentmanagement.repository.IClazzRepository;
import com.example.studentmanagement.repository.impl.ClazzRepository;
import com.example.studentmanagement.service.IClazzService;

import java.util.List;

public class ClazzService implements IClazzService {
    private IClazzRepository clazzRepository = new ClazzRepository();
    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }
}
