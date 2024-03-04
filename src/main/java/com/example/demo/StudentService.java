package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    public Student create(Student student) {
        return studentDao.create(student);
    }

    public Student updateById(Student student) {
        return studentDao.updateById(student);
    }

    public void deleteById(Integer studentId) {
        studentDao.deleteById(studentId);
    }


}
