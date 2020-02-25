package com.henningSB412.service;

import com.henningSB412.Dao.FakeStudentDaoImpl;
import com.henningSB412.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service //Service Layer
public class StudentService {
    @Autowired
    @Qualifier("fakeData")
    private FakeStudentDaoImpl fakeStudentDaoImpl;

    public Collection<Student> getAllStudents() {
        return this.fakeStudentDaoImpl.getAllStudents();
    }

    public Student getStudentById(int id) {
        return this.fakeStudentDaoImpl.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.fakeStudentDaoImpl.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        this.fakeStudentDaoImpl.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.fakeStudentDaoImpl.insertStudentToDb(student);
    }

    public void postStudent() {
        fakeStudentDaoImpl.turnLightOn();
    }

    public List<Student> getStudent() {
        return fakeStudentDaoImpl.getStudent();
    }
}

