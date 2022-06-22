package com.ghulam.controller;

import com.ghulam.entity.Teacher;
import com.ghulam.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student/teacher")
public class TeacherController {

	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/list")
	public String listTeacher(Model model) {
		// if record not available in database then getCustomers() given an error
		try {
			List<Teacher> teachers = teacherService.getTeachers();
			model.addAttribute("teachers", teachers);
		} catch (Exception e) {
			model.addAttribute("teachers", null);
		}
		return "teachers-list";
	}

	@GetMapping("/show-teacher-form")
	public String showTeacherForm(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher-form";
	}

	@GetMapping("/update-form")
	public String updateTeacherForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher-form";
	}

	@PostMapping("/save")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveOrUpdate(teacher);
		return "redirect:/student/teacher/list";
	}

	@GetMapping("/delete")
	public String deleteTeacher(@RequestParam("id") int id) {
		teacherService.delete(id);
		return "redirect:/student/teacher/list";
	}
}
