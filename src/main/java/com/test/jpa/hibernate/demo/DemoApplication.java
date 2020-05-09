package com.test.jpa.hibernate.demo;

import com.test.jpa.hibernate.demo.entity.Course;
import com.test.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Search result -> {} ", courseRepository.findById(100));
		courseRepository.deleteById(100);
		logger.info("Save course into DB-> {}",courseRepository.save(new Course( 12L,"AWS")));
		logger.info("upate a course in the DB -> {}",courseRepository.save(new Course(101L,"GCP")));
		courseRepository.tracking();
	}
}
