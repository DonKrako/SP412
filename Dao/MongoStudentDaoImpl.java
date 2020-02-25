package com.henningSB412.Dao;

import com.henningSB412.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Collection;
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao{


    @Override
    public Collection<Student> getAllStudents() {
        return null;}
        /*new ArrayList<Student>(){
            (new Student(1, "Mario", "nothing"))
        };
    }*/

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudentToDb(Student student) {

    }
}

