package com.example.demo;

import java.sql.Struct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public Student getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        List<Student> list = namedParameterJdbcTemplate.query(
            sql, map, new StudentRowMapper()
        );
        if (list.size() > 0 ) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public Student create(Student student) {
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return getById(student.getId());
    }

    public Student updateById(Student student) {
        String sql = "UPDATE student SET name = :studentName WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return getById(student.getId());
    }

    public void deleteById(Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
