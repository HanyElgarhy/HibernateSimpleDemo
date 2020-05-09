package com.test.jpa.hibernate.demo.entity;

import com.test.jpa.hibernate.demo.repository.CourseRepository;
import org.hibernate.tuple.entity.EntityTuplizer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	@Test
	public void query_non_typed(){
		Query query = entityManager.createQuery(" select c from Course c ");
		List resultList = query.getResultList();
		logger.info(" result of the query -> {}",resultList);

	}
	@Test
	public void query_typed(){
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info(" result from typed query -> {}", resultList);
	}
	@Test
	public void query_named_query(){
		TypedQuery<Course> first_sql = entityManager.createNamedQuery("first_SQL", Course.class);
		List<Course> resultList = first_sql.getResultList();
		logger.info("first SQL -> {}",resultList);
		TypedQuery<Course> second_sql = entityManager.createNamedQuery("second_SQL", Course.class);
		List<Course> resultList1 = second_sql.getResultList();
		logger.info("Second SQL -> {}",resultList1);
	}
	@Test
	public void query_name_parameter(){
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM COURSE where id=?", Course.class);
		nativeQuery.setParameter(1,10001l);
		List<Course> resultList = nativeQuery.getResultList();
		logger.info("result -> {}",resultList);
		Query nativeQuery1 = entityManager.createNativeQuery("Select * from Course where id=:id", Course.class);
		nativeQuery1.setParameter("id",10001l);
		List<Course> resultList1 = nativeQuery1.getResultList();
		logger.info(" result1 ->{}",resultList1);
	}

}
