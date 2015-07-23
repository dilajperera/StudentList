package com.sms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Student;

/**
 * This is the repository for student services.
 * The default CRUD operations of SpringMongo CrudRepository are used.
 * 
 * @author Dilaj
 */
@Repository("studentRepository")
public interface StudentRepository extends CrudRepository<Student, String>{
	
	//query ll be auto generated
	Student findByFirstName(String firstName);
}
