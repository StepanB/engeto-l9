package com.engeto.service;

import com.engeto.model.Student;
import com.engeto.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	private List<Student> students = new ArrayList<>();

	public void createDefualtStudents() {
		Student student1 = new Student();
		student1.setName("Stepan");
		student1.setSurname("Bohm");
		student1.setAge(38);
		student1.setId(1L);

		Student student2 = new Student();
		student2.setName("Franta");
		student2.setSurname("Student");
		student2.setAge(99);
		student2.setId(2L);

		students.add(student1);
		students.add(student2);
	}

	public List<Student> returnStudents() {
		return students;
	}

	public void createNewStudent(Student student) {
		students.add(student);
	}

	public void deleteStudent(Long id) {
		students.removeIf(student -> student.getId().equals(id));
	}

	public void updateStudent(Long id, Student student) {
		for (Student student1 : students) {
			if (student1.getId().equals(id)) {
				student1.setName(student.getName());
				student1.setSurname(student.getSurname());
				student1.setAge(student.getAge());
			}
		}
	}
}
