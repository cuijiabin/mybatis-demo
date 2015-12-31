package com.cuijiabin.dao;

import java.util.List;

import com.cuijiabin.model.Student;



/**
 * 
 * @ClassName: StudentDao 
 * @Description: TODO 
 * @author cuijiabin 
 * @date 2015年12月31日 下午4:05:54 
 *
 */
public interface StudentDao{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);

	void updateStudent(Student student);

}
