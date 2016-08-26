package com.embracesource.jpa.springdatajpa.service.teacherstudent;

//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

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
public class TestStudentsService {
	@Resource
	private TeachersRepository teachersRepository;
	
	@Resource
	private StudentsRepository studentsRepository;
	@Test
	public void initDataBase() {
		
	}
	
	/**
	 * 从关系的被维护方(学生方)查询
	 * 
	 */
	@Test
	public void testGetStudentsAndTeachers() {
		List<Students> students = studentsRepository.findAll();
		for (Students student : students) {
			System.out.println(student.getStudentName() + "被下面这些老师管理：");
			List<Teachers> teachers = student.getTeachers();
			for (Teachers teacher : teachers) {
				System.out.println(teacher.getTeacherName());
			}
		}
	}
	
}
