package com.example.ProjectFiles.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String city;
	 
    @Column(nullable = false,unique = true)
	private String state;

	@Column(nullable = false)
	private int zipcode;
	
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Author author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Address() {
		
	}

	public Address(int id, String city, String state, int zipcode, Author author) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.author = author;
	}
	
	
	
}
