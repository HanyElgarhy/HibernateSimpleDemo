package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.DemoApplication;
import com.test.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_course_present(){
        Optional<Course> course = repository.findById(100l);
        logger.info(" result is {}",course.isPresent());
    }
    @Test
    public void findById_course_not_present(){
        Optional<Course> course = repository.findById(10023l);
        logger.info(" result is {}",course.isPresent());
    }
    @Test
    public void findAll_and_sort(){
        //Sort sort= new Sort(Sort.Direction.DESC,"name");
        //List<Course> all = repository.findAll(sort);
    }
    @Test
    public void pagination(){
        PageRequest pageRequest=PageRequest.of(0,1);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("Firstpage {}",firstPage.getContent());
        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second page {}", secondPage.getContent());
    }


}
