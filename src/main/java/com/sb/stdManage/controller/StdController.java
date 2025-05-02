package com.sb.stdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.stdManage.entity.Student;
import com.sb.stdManage.service.StudentService;

@Controller
public class StdController {
	
	@Autowired
	private StudentService stdService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		List<Student> listStd = stdService.getAllStudents();
		return new ModelAndView("home","stds",listStd);
	}
	
	@GetMapping("/registerStdForm")
	public String registerStudent() {
		return "registerStudent";
	}
	
	@PostMapping("/registerStdFormSubmit")
	public String registerStdFormSubmit(Student std,Model model ) {
		boolean status = stdService.saveStudent(std);
		if(status) {
//			model.addAttribute("success", "Student Added");
			return "redirect:/";
		}else {
			model.addAttribute("error", "Student not Added");
			return "redirect:/registerStdForm";
		}
	}
	
	@GetMapping("/update-std/{id}")
	public ModelAndView updateStudent(@PathVariable("id") int id, Student std) {
		Student getStd = stdService.getStudentById(id);
		return new ModelAndView("updateStudent","std",getStd);
	}
	
	@GetMapping("/delete-std/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		try {
			stdService.deleteStudentById(id);
			return "redirect:/";
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/";
		}
	}
	
	
	
	
}
