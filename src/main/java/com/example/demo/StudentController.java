package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student insert(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public Student update(@PathVariable Integer studentId, @RequestBody Student student) {
        student.setId(studentId);
        return studentService.updateById(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void delete(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
    }
    
}
