package com.practice.WebService.model;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.practice.WebService.post.Post;

 

@Entity
public class Movie_Info {
    
    @Id
    private int movieId;
    private String movieName;
    private String movieDesc;
    
     @OneToMany(mappedBy = "movie")   //It will create a relationship column in the Post entity.
    private List<Post> posts;
    
    public Movie_Info() {
        super();
    }
    public Movie_Info(int movieId, String movieName, String movieDesc, Date birthDate) {
        super();
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
      //  this.birthDate = birthDate;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieDesc() {
        return movieDesc;
    }
    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }
    
     public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "Movie_Info [movieId=" + movieId + ", movieName=" + movieName + ", movieDesc=" + movieDesc
				+ "]";
	}
}