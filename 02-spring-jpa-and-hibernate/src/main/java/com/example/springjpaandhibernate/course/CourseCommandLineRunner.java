package com.example.springjpaandhibernate.course;

import com.example.springjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.springjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
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
    //@Autowired
    //private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {

        //this is for jdbc and jpa
        //repository.insert(new Course(1,"Learn Spring JPA","Ranga Karnam"));
        //repository.insert(new Course(2,"Learn Spring-Boot JPA","Ranga Karnam"));
        //repository.insert(new Course(3,"Learn AWS JPA","Ranga Karnam"));

        //insert for Spring Data JPA
        repository.save(new Course(1,"Learn Spring Data JPA","Ranga Karnam"));
        repository.save(new Course(2,"Learn Spring-Boot Data JPA","Ranga Karnam"));
        repository.save(new Course(3,"Learn AWS Data JPA","Ranga Karnam"));

        //give long value so append 1 with L to make it Long
        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
}
