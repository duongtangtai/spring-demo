package com.example.springdemo.controllers;
import com.example.springdemo.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    @Qualifier("getStudentList")
    private List<StudentModel> studentModelList;
    @PostMapping("/request-param")
    public ResponseEntity<List<StudentModel>> addStudentWithRequestParam(@RequestParam("name") String name,
                                                        @RequestParam("age") int age) {
        StudentModel studentModel = context.getBean(StudentModel.class);
        studentModel.setName(name);
        studentModel.setAge(age);
        studentModelList.add(studentModel);
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }
    @PostMapping("/{name}/{age}")
    public ResponseEntity<List<StudentModel>> addStudentWithPathVariable(@PathVariable("name") String name,
                                                                         @PathVariable("age") int age) {
        StudentModel studentModel = context.getBean(StudentModel.class);
        studentModel.setName(name);
        studentModel.setAge(age);
        studentModelList.add(studentModel);
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }
    @PostMapping("/request-body")
    public ResponseEntity<List<StudentModel>> addStudentWithRequestBody(@RequestBody StudentModel studentModel) {
        studentModelList.add(studentModel);
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }
}
