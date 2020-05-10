package com.test.jpa.hibernate.demo;

import com.test.jpa.hibernate.demo.entity.Course;
import com.test.jpa.hibernate.demo.entity.Review;
import com.test.jpa.hibernate.demo.entity.Student;
import com.test.jpa.hibernate.demo.repository.CourseRepository;
import com.test.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EntityManager entityManager;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Course course = courseRepository.findById(100);
		Student tom = new Student("Tom");
		course.addStudents(tom);
		Student tomCuiz = new Student("TomCuiz");
		course.addStudents(tomCuiz);
		entityManager.persist(tom);
		entityManager.persist(tomCuiz);


	}
}
