package com.practice.WebService.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.WebService.dao.movieRepo;
import com.practice.WebService.dao.postRepo;
import com.practice.WebService.model.Movie_Info;
import com.practice.WebService.post.Post;

@RestController
public class Controller {
	
	@Autowired
	private movieRepo movieRepo;
	
	@Autowired
	private postRepo postRepo;
	
	@GetMapping("/allmovie")
	private List<Movie_Info> getAlluser(){
		return movieRepo.findAll();
	}
	
	@GetMapping("/movie/{id}")
	private Optional<Movie_Info> mymovie(@PathVariable int id){
		Optional<Movie_Info> movie= movieRepo.findById(id);  
		if(!movie.isPresent())  
		return movie;
	     return movie;
	}
	
	@GetMapping("/movie/{id}/posts")
	public List<Post> allMovie(@PathVariable int id) throws Exception{
		Optional<Movie_Info> movieinfo = movieRepo.findById(id);  
		if(!movieinfo.isPresent()) {  
		throw new Exception("id: "+ id);  
		}  
		return movieinfo.get().getPosts();  
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteUser(@PathVariable int id) {	
		movieRepo.deleteById(id);
		}
	
	@PostMapping("/movie")
	public Movie_Info createUser(@RequestBody Movie_Info movie) {
     Movie_Info savedMovie = movieRepo.save(movie);
	return savedMovie;
}
	
	@PostMapping("/movie/{id}/posts")  
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) throws Exception{  
	Optional<Movie_Info> movieOptional = movieRepo.findById(id);  
	
	if(!movieOptional.isPresent()) {
		throw new Exception("id: "+ id); 
		}
	Movie_Info movieinfo = movieOptional.get();     
	//map the user to the post  
	post.setMovie(movieinfo);
	//save post to the database  
	postRepo.save(post);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();  
	//returns the location of the created post  
	return ResponseEntity.created(location).build();  
	}  
}

