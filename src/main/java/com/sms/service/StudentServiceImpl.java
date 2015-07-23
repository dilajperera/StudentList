package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.model.Student;
import com.sms.repo.StudentRepository;


/**
 * This is the service layer to provide services for 
 * REST controllers. Each method is handled in a transaction.
 * In a failure situation, entire transaction will be roll back.   
 * @author Dilaj
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * This method returns details of students
	 */
	@Transactional
	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	/**
	 * This method saves/update a student
	 * @param student - student to be saved or updated
	 * @return - saved student
	 */
	@Transactional
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
		
	}

}
