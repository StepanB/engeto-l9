package com.engeto.controller;

import com.engeto.model.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
public class TeachersController {

	@GetMapping()
	public Teacher getTeacher() {
		return new Teacher("John", "Doe", 21);
	}
}
