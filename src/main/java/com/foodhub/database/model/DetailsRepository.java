package com.foodhub.database.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long>{

	List<Details> findByuserName(String userName);
	List<Details> findAll();
	
	@Transactional
	void deleteByuserName(String userName);
}
