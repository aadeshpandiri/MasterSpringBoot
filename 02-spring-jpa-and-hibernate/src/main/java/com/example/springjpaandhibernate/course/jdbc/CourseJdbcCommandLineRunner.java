package com.example.springjpaandhibernate.course.jdbc;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.springjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"Learn Spring","Ranga Karnam"));
        repository.insert(new Course(2,"Learn Spring-Boot","Ranga Karnam"));
        repository.insert(new Course(3,"Learn AWS","Ranga Karnam"));

        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
