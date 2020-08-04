package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
