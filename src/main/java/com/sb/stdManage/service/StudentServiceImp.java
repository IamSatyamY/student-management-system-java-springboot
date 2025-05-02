package com.sb.stdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.stdManage.entity.Student;
import com.sb.stdManage.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository stdRepo;
	
	@Override
	public Boolean saveStudent(Student std) {
		// TODO Auto-generated method stub
		try {
			stdRepo.save(std);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stdRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return stdRepo.findById(id).get();
	}


	@Override
	public String deleteStudentById(int id) {
		try {
			stdRepo.deleteById(id);
			return "succes";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}
	
	

}
