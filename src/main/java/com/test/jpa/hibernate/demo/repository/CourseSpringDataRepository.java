package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.Path;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface CourseSpringDataRepository extends JpaRepository <Course,Long> {
    List<Course> findByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);
    @Query("Select c from Course c where name like '%100 steps'")
    List<Course> courseWith100Steps();
    @Query(value = "Select * from Course c where name like '%100 steps'",nativeQuery = true)
    List<Course> courseWith100StepsNativeQuery();
    @Query(name="first_SQL")
    List<Course> callQueryName();

}
