package com.tech.tests.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.tests.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
	
	boolean existsByTestName(String testName);
	
	@Query("select t from Test t")
	List<Test> findAllTest();
	
	@Query("select t from Test t where t.createBy=:userId")
	List<Test> findAllMyTest(@Param("userId")Long userId);
	
	@Query("select t from Test t where t.id=:testId")
	Optional<Test> findById(@Param("testId")Long testId);
	
	

}
