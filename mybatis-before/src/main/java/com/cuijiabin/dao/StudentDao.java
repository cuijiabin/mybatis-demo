package com.cuijiabin.dao;

import com.cuijiabin.model.Student;

import java.util.List;

/**
 * dao接口声明
 *
 * @author cuijiabin
 */
public interface StudentDao {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);

    void updateStudent(Student student);

}
