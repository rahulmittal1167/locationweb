package com.rahul.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
import com.rahul.location.entities.Location;


public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	@Query(value="select type, count(type) from location group by type", nativeQuery = true)  //jpql  
	public List<Object[]> findByTypeAndTypeCount();				// Object[0] --> type, Object[1]--> count

}
