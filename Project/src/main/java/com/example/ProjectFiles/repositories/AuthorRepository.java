package com.example.ProjectFiles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ProjectFiles.models.Author;
import com.example.ProjectFiles.projections.AuthorWithoutPhone;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

	List<AuthorWithoutPhone> findAllProjectedBy();
	
	
}
