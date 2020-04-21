package com.rahul.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rahul.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
				// Object[0] --> type, Object[1]--> count

}
