# StudentList

The StudentList is a single page web application to manage details of students. Following technologies/tools are used to implement the application.
	•	RESTful API – Spring, Java EE
	•	NoSQL Database – Mongo 
	•	UI – Angular JS Frame Work , HTML, Bootstrap 
	•	Maven 3.3.1
	•	TomCat 7/8
	•	Git
	•	Java 7/8 
	
The application has deployed in the Red Hat open shift public cloud. It can be accessed through the following url,
	http://studentlist-stdsys.rhcloud.com/

Follow these steps to build and deploy the StudentList application.
	1.	Clone the git repository or download the source code as a zip file.
			Public git url  :  https://github.com/dilajperera/StudentList.git

	2.	If it is the zip file, the extract the zip file. The main folder will be StudentList.

	3.	Configure the database settings as required, Property File location: 		StudentList\src\main\resources\mongo.properties

					mongo.database=sms
					mongo.host=127.0.0.1
					mongo.port=27017
					mongo.username=root
					mongo.password=root

4.	Go to the inside of StudentList folder. Open a cmd and execute the command mvn clean install. After building process is 	completed, sms.war will be created inside the target folder. (StudentList\target\sms.war).

5.	Deploy the sms.war in the tomcat 7/8.

