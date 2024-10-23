package com.nandini;

import com.nandini.dao.StudentDao;
import com.nandini.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllTheStudent(studentDao);
		};
	}

	private void deleteAllTheStudent(StudentDao studentDao) {
		System.out.println("deleting all the students.");
		int deletedRows = studentDao.deleteAll();;
		System.out.println(deletedRows);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		//change the first name to scooby
		System.out.println("updating student....");
		myStudent.setFirstName("Scooby");
		myStudent.setEmail("scooby@gmail.com");

		//update the student
		studentDao.update(myStudent);

		//display the updated student
		System.out.println("updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get the student list
		List<Student> theStudents = studentDao.findByLastName("negi");

		//display the student list
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of student
		List<Student> theStudents = studentDao.findAll();

		//display list of student
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {

		//create the student object
		System.out.println("creating the student object..");
		Student tempStudent = new Student("Deepali","Negi","deepali@gmail.com");

		//save the student object
		studentDao.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("retrieve student with id:" + theId);
		Student myStudent = studentDao.findById(theId);

		//display student
		System.out.println("found the student:" + myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		//create multiple student object
		System.out.println("creating 3 new student object...");
		Student tempStudent1 = new Student("priya","jain","priya@gmail.com");
		Student tempStudent2 = new Student("sonali","mital","sonali@gmail.com");
		Student tempStudent3 = new Student("teena","doe","teena@gmail.com");


		//save student object
		System.out.println("Saving the students...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		//create student object
		System.out.println("creating new student object...");
		Student tempStudent = new Student("neha","paul","neha@gmail.com");

		//save student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id: " + tempStudent.getId());
	}
}
