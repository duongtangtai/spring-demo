package com.example.springdemo.config;

import com.example.springdemo.models.StudentModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    @Scope("prototype")
    public StudentModel getStudent() {
        return new StudentModel();
    }
    @Bean
    public List<StudentModel> getStudentList() {
        return new ArrayList<>();
    }
}
