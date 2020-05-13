package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Address;
import com.test.jpa.hibernate.demo.entity.Passport;
import com.test.jpa.hibernate.demo.entity.Student;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentAndPassport(){
        Student student = entityManager.find(Student.class, 1000L);
        logger.info(" student is {}",student);
        student.getPassport();
        logger.info("passport is ",student.getPassport());

    }
    @Test
    @Transactional
    public void playWithPersistenceContext(){
        Student student = entityManager.find(Student.class, 1000L);
        Passport passport = student.getPassport();
        student.setName("Rico");
        passport.setNumber("AAA");
        Passport passport1=entityManager.find(Passport.class,2000L);
        logger.info(" passport get student {}",passport1.getStudent());

    }
    @Test
    @Transactional
    public void retrieveStudent(){
        Student student = entityManager.find(Student.class, 1000L);
        logger.info(" student is {}", student);
        logger.info("Student courses {}",student.getCourses());
    }
    @Test
    @Transactional
    public void setAddressDetails(){
        Student student= entityManager.find(Student.class,1000L);
        student.setAddress(new Address("Montreal","Lajeunesse","666"));
        entityManager.flush();
        logger.info(" student and address {}", student.getAddress());
    }


}
