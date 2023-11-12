package com.example.springjpaandhibernate.course.springdatajpa;

import com.example.springjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {
    //create custom queries
    //let say find courses by author
    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
