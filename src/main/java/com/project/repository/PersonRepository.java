package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{
	

}
