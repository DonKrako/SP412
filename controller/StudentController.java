package com.henningSB412.controller;


import com.henningSB412.entity.Student;
import com.henningSB412.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController


@RequestMapping("/Tags")//Pfadangabe

public class StudentController {
    @Autowired
    private StudentService studentService; //deklariert studentService als Datentyp StudentService

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        System.out.println("GetStudent");
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//Methode um studenten per ID aufzurufen:localhost:8080/students/3
    //@Request ruft getStudentById auf
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
       studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
        System.out.println("PostStudent");
    }
    @RequestMapping(value = "/commonIn", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void neu(@RequestBody Student student){
        System.out.println("WTF");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)//Methode um studenten per ID aufzurufen:localhost:8080/students/3
    //@Request ruft getStudentById auf
    public List<Student> test(){
        studentService.postStudent();
        return studentService.getStudent();
    }

}
