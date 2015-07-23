package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Student;
import com.sms.service.StudentServiceImpl;

/**
 * This the REST api of the studenlist application.
 * url pattern: http://...../sms/students.json
 * .json is added as the suffix of the url to identify
 * json requests.
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
	
	/**
	 * This method saves a new student or 
	 * edits an existing student. student is validated before invoking
	 * the services.
	 * @param student - student to be saved or updated
	 * @param bindingResult - to check whether validation errors
	 * @return newly saved/updated student
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Student addStudent(@RequestBody @Valid Student student, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			logger.info("Validation fail - student {name : {} {} } ll be added",student.getFirstName(),student.getLastName());
		}
		logger.info("A new student {name : {} {} } ll be added",student.getFirstName(),student.getLastName()); 
		return studentService.saveStudent(student);
	}

	/**
	 * This methods gives details of students
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
		logger.info("Students details ll be loaded..."); 
		return studentService.getAllStudents();
    }
	
	/**
	 * This method deletes an existing student
	 * @param student
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteStudent(@RequestBody Student student) {
		logger.info("The student {id : {}, name : {} } ll be updated",student.getId(),student.getFirstName()); 
		studentService.deleteStudent(student);
	}
}
