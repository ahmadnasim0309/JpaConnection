package com.practice.WebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.WebService.model.Movie_Info;

@Repository
public interface hcl extends JpaRepository<Movie_Info, Integer> {

}
