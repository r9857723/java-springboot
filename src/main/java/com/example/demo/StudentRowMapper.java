package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
// import org.springframework.lang.Nullable;

public class StudentRowMapper implements RowMapper<Student>{

    @Override
    // @Nullable
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        return student;
    }

}
