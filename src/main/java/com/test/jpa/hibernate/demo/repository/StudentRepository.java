package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Course;
import com.test.jpa.hibernate.demo.entity.Passport;
import com.test.jpa.hibernate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Struct;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager entityManager;

    public Student findById(long id){
        return entityManager.find(Student.class,id);
    }
    public void deleteById(int id){
        Student student=findById(id);
        entityManager.remove(student);
    }
    public Student save(Student student){
        if(student.getId()==null)
            entityManager.persist(student);
        else
            entityManager.merge(student);
        return student;
    }

    public void tracking(){
        Passport passport = new Passport("EN120");
        entityManager.persist(passport);
        Student student= new Student("Daniel");
        student.setPassport(passport);
        entityManager.persist(student);


    }

}
