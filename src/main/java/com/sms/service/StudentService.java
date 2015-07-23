package com.sms.service;

import java.util.List;

import com.sms.model.Student;
/**
 * This is the interface for Student services,
 * which are consumed by the rest API.
 * @author Dilaj
 *
 */
public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	void deleteStudent(Student student);
}
