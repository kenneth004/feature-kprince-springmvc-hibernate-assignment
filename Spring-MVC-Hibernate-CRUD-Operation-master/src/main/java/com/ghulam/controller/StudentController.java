package com.ghulam.controller;

import com.ghulam.entity.Student;
import com.ghulam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/list")
	public String listStudent(Model model) {
		// if record not available in database then getCustomers() given an error
		try {
			List<Student> students = studentService.getStudents();
			model.addAttribute("students", students);
		} catch (Exception e) {
			model.addAttribute("students", null);
		}
		return "students-list";
	}

	@GetMapping("/show-student-form")
	public String showStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	@GetMapping("/update-form")
	public String updateStudentForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveOrUpdate(student);
		return "redirect:/student/list";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.delete(id);
		return "redirect:/student/list";
	}
	
	
}
