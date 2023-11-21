package com.engeto.controller;

import com.engeto.model.Student;
import com.engeto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

	private StudentService studentService;

	public StudentsController(@Autowired StudentService studentService) {
		this.studentService = studentService;
	}


	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> students = studentService.returnStudents();
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		Student student = new Student();
		student.setName("Stepan");
		student.setSurname("Bohm");
		student.setAge(38);
		student.setId(id);

		return student;
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {

		studentService.createNewStudent(student);

		return student;
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
	}

	@PutMapping("/students/{id}")
	public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}

	@GetMapping("/students/create")
	public void createDefaultStudents() {
		studentService.createDefualtStudents();
	}
}
