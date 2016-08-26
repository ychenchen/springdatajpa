package com.embracesource.jpa.springdatajpa.service.teacherstudent;

//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.embracesource.jpa.springdatajpa.domain.teacherstudent.Students;
import com.embracesource.jpa.springdatajpa.domain.teacherstudent.Teachers;
import com.embracesource.jpa.springdatajpa.repository.teacherstudent.StudentsRepository;
import com.embracesource.jpa.springdatajpa.repository.teacherstudent.TeachersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestTeachersService {
	@Resource
	private TeachersRepository teachersRepository;
	
	@Resource
	private StudentsRepository studentsRepository;
	
	@Test
	public void testSaveTeacherAndStudents() throws Exception {
		Teachers teacher = new Teachers();
		teacher.setTeacherCode("t0001");
		teacher.setTeacherName("刘老师");

		List<Students> students = new ArrayList<Students>();
		
		Students student1 = new Students();
		student1.setStudentCode("s0001");
		student1.setStudentName("杨同学");
		students.add(student1);
		
		Students student2 = new Students();
		student2.setStudentCode("s0002");
		student2.setStudentName("王同学");
		students.add(student2);

		Students student3 = new Students();
		student3.setStudentCode("s0003");
		student3.setStudentName("李同学");
		students.add(student3);

		teacher.setStudents(students);
		studentsRepository.save(students);
		teachersRepository.save(teacher);
	}
	
	/**
	 * 从关系的维护方(老师方)查询
	 * 
	 */
	@Test
	public void testGetTeachersAndStudents() {
		List<Teachers> teachers = teachersRepository.findAll();
		for (Teachers teacher : teachers) {
			System.out.println(teacher.getTeacherName()+"管理如下学生：");
			List<Students> students = teacher.getStudents();
			for (Students student : students) {
				System.out.println(student.getStudentName());
			}
		}
	}
	
	
	
}
