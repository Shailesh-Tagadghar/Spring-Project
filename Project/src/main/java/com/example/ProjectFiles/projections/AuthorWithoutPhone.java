package com.example.ProjectFiles.projections;

import org.springframework.beans.factory.annotation.Value;

import com.example.ProjectFiles.models.Address;

//import com.example.ProjectFiles.models.Address;

public interface AuthorWithoutPhone {
	
	@Value("#{target.id}")
	int getId();
	
	@Value("#{target.author_name}")
	String getAuthor_name();
	
	@Value("#{target.age}")
	int getAge();
	
	@Value("#{target.address}")
	Address getAddress();
	
}
