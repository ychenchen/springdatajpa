package com.embracesource.jpa.springdatajpa.domain.teacherstudent;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "teachers")
public class Teachers extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "teacher_code",length = 50, unique=true)
	private String teacherCode;
	
	@Column(name = "teacher_name",length = 50,insertable=true,updatable=true)
	private String teacherName;
	
	@ManyToMany
	@JoinTable(name="teacher_student",
			joinColumns=@JoinColumn(name="teacher_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id"))
	private List<Students> students;

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}
	
}
