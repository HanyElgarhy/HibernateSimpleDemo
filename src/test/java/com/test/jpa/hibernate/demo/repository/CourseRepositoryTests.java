package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseRepositoryTests {

	@Autowired
	CourseRepository courseRepository;
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

}
