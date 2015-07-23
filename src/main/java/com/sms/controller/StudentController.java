package com.sms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Student;
import com.sms.service.StudentServiceImpl;

/**
 * 
 * @author Dilaj
 *
 */
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	
	@RequestMapping(method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		logger.info("A new student {name : {} {} } ll be added",student.getFirstName(),student.getLastName()); 
		return studentService.registerStudent(student);
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
		logger.info("Students details ll be loaded..."); 
		return studentService.getAllStudents();
    }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteStudent(@RequestBody Student student) {
		logger.info("The student {id : {}, name : {} } ll be updated",student.getId(),student.getFirstName()); 
		studentService.deleteStudent(student);
	}
}
