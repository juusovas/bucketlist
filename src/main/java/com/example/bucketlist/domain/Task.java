package com.example.bucketlist.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String what;
	private String whereis;
	private String whenis;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User username;

	/*
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	String formattedString = whenis.format(formatter);
	*/
	
	public Task() {
	}

	public Task(String what, String whereis, String whenis, Category category, User username) {
		super();
		this.what = what;
		this.whereis = whereis;
		this.whenis = whenis;
		this.category = category;
		this.username = username;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getWhereis() {
		return whereis;
	}

	public void setWhereis(String whereis) {
		this.whereis = whereis;
	}

	public String getWhenis() {
		return whenis;
	}

	public void setWhenis(String whenis) {
		this.whenis = whenis;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Task [id=" + id + ", what" + what + ", where=" + whereis + ", when=" + whenis + ", category ="
					+ this.getCategory() + ", username =" +this.getUsername() + "]";

		else
			return "Task [id=" + id + ", what=" + what + ", where=" + whereis + ", when=" + whenis + "]";

	}


}
