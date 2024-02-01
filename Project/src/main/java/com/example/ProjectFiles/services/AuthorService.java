package com.example.ProjectFiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ProjectFiles.models.Address;
import com.example.ProjectFiles.models.Author;
import com.example.ProjectFiles.projections.AuthorWithoutPhone;
import com.example.ProjectFiles.repositories.AddressRepository;
import com.example.ProjectFiles.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public Iterable<Author> getAllAuthorWithPhone(){
		return authorRepository.findAll();
	}
	
	public List<AuthorWithoutPhone> getAllAuthorWithoutPhone(){
		return authorRepository.findAllProjectedBy();
	}
	
//	public Author createAuthor(Author author) {
//		Address got_address = author.getAddress();
//		Address saved_address = addressRepository.save(got_address);
//		author.setAddress(saved_address);
//		return authorRepository.save(author);
//	}
	
	public Author createAuthor(Author author) {
        Address gotAddress = author.getAddress();

        if (gotAddress.getId() == 0) {
            Address savedAddress = addressRepository.save(gotAddress);
            author.setAddress(savedAddress);
        } else {
            Address existingAddress = addressRepository.findById(gotAddress.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
            
            existingAddress.setCity(gotAddress.getCity());
            existingAddress.setState(gotAddress.getState());
            existingAddress.setZipcode(gotAddress.getZipcode());
//            addressRepository.save(existingAddress);
        }
        return authorRepository.save(author);
    }
	
	public Optional<Author> getAuthorById(int id){
		return authorRepository.findById(id);
	}
	
	public void deleteAuthorById(int id) {
		authorRepository.deleteById(id);
	}
	
	public Author updateAuthorById(int id, Author updatedAuthor){
		if(authorRepository.existsById(id)) {
			updatedAuthor.setId(id);
			return authorRepository.save(updatedAuthor);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author not found with Id : "+id);
		}
	}
	
}
