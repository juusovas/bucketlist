package com.example.bucketlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String what;
	private String where;
	private String when;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Task() {}
	
	public Task(String what, String where, String when, Category category) {
		super();
		this.what = what;
		this.where = where;
		this.when = when;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	
	

	@Override
	public String toString() {
		if (this.category != null)
			return "Task [id=" + id + ", what" + what + ", where=" + where + ", when=" + when + " category =" + this.getCategory() + "]";
		
		else
		return "Task [id=" + id + ", what=" + what + ", where=" + where + ", when=" + when + "]";
			
	}

	
	
}
