package com.practice.WebService.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.WebService.dao.hcl;
import com.practice.WebService.model.Movie_Info;

@RestController
public class ControllerDemo {
	
	@Autowired
	private hcl example;
	
	@GetMapping("/allmovie")
	private List<Movie_Info> getAlluser(){
		return example.findAll();
	}
	
	@GetMapping("/movie/{id}")
	private Optional<Movie_Info> myuser(@PathVariable int id){
		Optional<Movie_Info> user= example.findById(id);  
		if(!user.isPresent())  
		return user;
	    return user;
	}
}
