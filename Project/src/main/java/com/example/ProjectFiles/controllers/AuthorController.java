package com.example.ProjectFiles.controllers;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.ProjectFiles.AuthorResponseWrapper;
import com.example.ProjectFiles.models.Address;
import com.example.ProjectFiles.models.Author;
import com.example.ProjectFiles.projections.AuthorWithoutPhone;
import com.example.ProjectFiles.repositories.AuthorRepository;
import com.example.ProjectFiles.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	
	@GetMapping("")
	public ResponseEntity<?> getAllAuthorWithPhone(){
		Iterable<Author> data = authorService.getAllAuthorWithPhone();
		Iterator<Author> all_authors = data.iterator();
		if(!all_authors.hasNext()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO Author Found");
		}
		else {
			AuthorResponseWrapper arr = new AuthorResponseWrapper();
			arr.setMessage("Author Found");
			arr.setData(all_authors);
			return new ResponseEntity<>(arr,HttpStatus.OK);
		}
	}
	
	@GetMapping("/without-phone")
	public ResponseEntity<?> getAllAuthorWithoutPhone(){
		Iterable<AuthorWithoutPhone> data = authorService.getAllAuthorWithoutPhone();
		Iterator<AuthorWithoutPhone> all_authors = data.iterator();
		
		if(!all_authors.hasNext()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO Author Found");
		}
		else {
			AuthorResponseWrapper arr = new AuthorResponseWrapper();
			arr.setMessage("Author Found");
			arr.setData(all_authors);
			return new ResponseEntity<>(arr,HttpStatus.OK);
		}
	}
	
	 @PostMapping("")
	 public ResponseEntity<?> createAuthor(@RequestBody Author author){
		 Author createdAuthor = authorService.createAuthor(author);
		 AuthorResponseWrapper arr = new AuthorResponseWrapper();
		 arr.setMessage("Author found");
		 arr.setData(createdAuthor);
		 return new ResponseEntity<>(arr,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<?> getAuthorById(@PathVariable int id){
		 Optional<Author> author = authorService.getAuthorById(id);
		 if(author.isPresent()) {
			 AuthorResponseWrapper arr = new AuthorResponseWrapper();
			 arr.setMessage("Author found");
			 arr.setData(author.get());
			 return new ResponseEntity<>(arr,HttpStatus.OK);
		 }
		 else {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author Not Found with Id : "+id);
		 }
	 }
	 
	   @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteAuthorById(@PathVariable int id) {
	        authorService.deleteAuthorById(id);
	        AuthorResponseWrapper arr = new AuthorResponseWrapper();
	        arr.setMessage("Author deleted successfully");
	        return new ResponseEntity<>(arr, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateAuthorById(@PathVariable int id, @RequestBody Author updatedAuthor) {
	        Author author = authorService.updateAuthorById(id, updatedAuthor);
	        AuthorResponseWrapper arr = new AuthorResponseWrapper();
	        arr.setMessage("Author updated successfully");
	        arr.setData(author);
	        return new ResponseEntity<>(arr, HttpStatus.OK);
	    }
	 
}
