package com.cuijiabin.test;

import com.cuijiabin.model.Student;
import com.cuijiabin.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore
public class TestService {

	private static StudentService studentService;
	
	private Logger logger = Logger.getLogger(TestService.class);
	
	@Before
	public void before() {
		logger.info("before");
	}
	
	@After
	public void after() {
		logger.info("after");
	}

	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		for (Student student : students) {
			 System.out.println(student);
		}

	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		System.out.println(student);
	}

	@Test
	public void testCreateUStudent() {
		Student student = new Student();
		int id = 4;
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "gmail.com");
		student.setDob(new Date());
		studentService.createStudent(student);
		Student newStudent = studentService.findStudentById(id);
		assertNotNull(newStudent);
		assertEquals("student_" + id, newStudent.getName());
		assertEquals("student_" + id + "gmail.com", newStudent.getEmail());
	}

	@Test
	public void testUpdateStudent() {
		int id = 2;
		Student student = studentService.findStudentById(id);
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "gmail.com");
		Date now = new Date();
		student.setDob(now);
		studentService.updateStudent(student);
		Student updatedStudent = studentService.findStudentById(id);
		assertNotNull(updatedStudent);
		assertEquals("student_" + id, updatedStudent.getName());
		assertEquals("student_" + id + "gmail.com", updatedStudent.getEmail());

	}
}
