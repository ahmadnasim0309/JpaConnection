package com.practice.WebService.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.WebService.model.Movie_Info;

@Entity
public class Post {
	
	@Id
	private int id;
	private String desc;
	
	@ManyToOne(fetch = FetchType.LAZY)    //The fetch type will not retrieve the details of the Movie_Info unless we called Post.getMovie_Info
	@JsonIgnore         //There is no need to show user detail in the response, so we will add @JsonIgnore
	private Movie_Info movie;
	
	public Post() {
		super();
	}

	public Post(int id, String desc, Movie_Info movie) {
		super();
		this.id = id;
		this.desc = desc;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Movie_Info getMovie() {
		return movie;
	}

	public void setMovie(Movie_Info movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", desc=" + desc + "]";
	}
}
