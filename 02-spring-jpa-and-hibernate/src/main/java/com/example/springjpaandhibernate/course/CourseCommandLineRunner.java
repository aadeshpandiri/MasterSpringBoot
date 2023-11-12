package com.example.springjpaandhibernate.course;

import com.example.springjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//changed name and moved under course package so that we can use it for both jpa and jdbc
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //to work with jdbc repository
    //@Autowired
    //private CourseJdbcRepository repository;

    //to work with jpa repository
    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"Learn Spring JPA","Ranga Karnam"));
        repository.insert(new Course(2,"Learn Spring-Boot JPA","Ranga Karnam"));
        repository.insert(new Course(3,"Learn AWS JPA","Ranga Karnam"));

        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
