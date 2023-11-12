package com.example.springjpaandhibernate.course.jdbc;

import com.example.springjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(?,?,?);
    
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

}