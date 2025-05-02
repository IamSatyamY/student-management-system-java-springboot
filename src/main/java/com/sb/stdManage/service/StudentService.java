package com.sb.stdManage.service;

import java.util.List;

import com.sb.stdManage.entity.Student;

public interface StudentService {
	Boolean saveStudent(Student std);
	
	List<Student> getAllStudents();
	Student getStudentById(int id);

	String deleteStudentById(int id);
	
	
}
