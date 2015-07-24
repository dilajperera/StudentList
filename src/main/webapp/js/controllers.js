angular.module('controllers',['studentService']).
	controller('studentCtrl', ['$scope','studentFactory',function($scope,studentFactory){
		
        $scope.studentList = [];
        $scope.student = {};
        getAllStudents();
        $scope.enableEditPanel = false;
        $scope.successMessage = false;
        
        //to add/update student 
		$scope.addStudent = function(student){
			studentFactory.addStudent(student).then(function(student) {
				$scope.enableEditPanel = !$scope.enableEditPanel;
				$scope.student = {};
				$scope.successMessage = true;
            },
            function(data) {
                console.log('students details can not be saved');
            });
		}
		
		//to get all details about students
		function getAllStudents(){
			studentFactory.getAllStudents().then(function(students) {
				$scope.studentList = students;
				console.log($scope.studentList);
            },
            function(data) {
                console.log('students details can not be loaded');
            });
		};	

		//to bind update student with scope
		$scope.editStudent = function(student){
			console.log('edit a student');
			$scope.student = student;
			console.log(student);
			$scope.enableEditPanel = !$scope.enableEditPanel;
			$scope.successMessage = false;
		}
		
		//to delete a student
		$scope.deleteStudent = function(deleteStudent){
			console.log('delete a student');
			$scope.student = {};
			var student = {};
			var tempList = [];
			
			for(var i = 0; i < $scope.studentList.length; i++){
				student = $scope.studentList[i];
				if(student.id !== deleteStudent.id){
					tempList.push(student);
				}
			}
			
			$scope.studentList = tempList;
			studentFactory.deleteStudent(student);
			$scope.enableEditPanel = false;
		}
		
}]);