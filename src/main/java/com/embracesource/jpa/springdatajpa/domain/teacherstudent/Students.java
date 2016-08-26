package com.embracesource.jpa.springdatajpa.domain.teacherstudent;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "students")
public class Students extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_code",length = 50, unique=true)
	private String studentCode;
	
	@Column(name = "student_name",length = 50,insertable=true,updatable=true)
	private String studentName;
	
	@ManyToMany(mappedBy="students")
	private List<Teachers> teachers;

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}

}
