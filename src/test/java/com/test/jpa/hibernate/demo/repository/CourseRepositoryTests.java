package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Course;
import com.test.jpa.hibernate.demo.entity.Review;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseRepositoryTests {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	EntityManager entityManager;
	@Test
	void courseRepository_find_by_id() {
		assertEquals("Spring", courseRepository.findById(100).getName());
	}
	@Test
	@DirtiesContext
	void courseRepository_delete_by_id() {
		courseRepository.deleteById(101);
		assertNull(courseRepository.findById(101));
	}

	@Test
	@DirtiesContext
	void setCourseRepository_save(){
		courseRepository.save(new Course( 101L,"Test saving using Junit"));
		assertEquals("Test saving using Junit", courseRepository.findById(101L).getName());
	}
	@Test
	@Transactional
	void fetchManyToOneFromDb(){
		Course course = courseRepository.findById(100);
		logger.info("Course.getreview {}",course.getReview());
		Review review = entityManager.find(Review.class, 3000l);
		logger.info(" review.getcourse {}",review.getCourse());
	}

}
