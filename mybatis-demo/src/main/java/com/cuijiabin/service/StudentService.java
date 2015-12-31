package com.cuijiabin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cuijiabin.dao.StudentDao;
import com.cuijiabin.model.Student;
import com.cuijiabin.util.MyBatisSqlSessionFactory;

/**
 * 
 * @ClassName: StudentService
 * @Description: TODO
 * @author cuijiabin
 * @date 2015年12月31日 下午4:13:36
 *
 */
public class StudentService {
	private Logger logger = Logger.getLogger(getClass());

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}

	public Student findStudentById(Integer studId) {
		logger.debug("Select Student By ID :{}" + studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public void createStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentDao.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentDao.updateStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
