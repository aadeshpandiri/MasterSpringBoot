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

    private static String DELETE_QUERY =
            """
                delete from course where id = ?
            """;

    private static String SELECT_QUERY =
            """
                select * from course where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id){
    //Here when we query , result set will be generated but here we want our output in Course format
    //so ResultSet should Convert into Course Bean
    //we can do this using RowMappers
    //when we want to query for single row , we can go for queryForObject
    //Takes 3 Arg - 2nd is instance of Row Mapper i.e. BeanPropertyRowMapper<>(BeanClass)
        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }

}