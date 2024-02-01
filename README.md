# Spring-Project



Book Management System

1.	Open Spring Tool
2.	Create Spring Starter Project – book
3.	Add Dependency – Spring Web, Spring Data JPA, MySQL Driver and Lombok.
4.	Create Project – Click Finish
5.	Wait till project build 
6.	Open src/main/resources/application.properties -- 
 
7.	Create Model Folder – create two class User.java and Book.java
User.java File
 

Book.java File
 

8.	Create Repository Folder :
UserRepository.java
 

BookRepository.java
 

9.	Create Service Folder:
UserService.java
 
BookService.java
 




10.	Create Controller Folder:
UserController.java
 

BookController.java
 

Folder Flow –
 

Starting With Project :
1.	Start Project -- Boot Dashboard
2.	It will Create two tables in database:
 
3.	Other All Steps is going to perform on Postman
4.	Adding User using postman : 
url - http://localhost:8090/api/users
 

5.	Fetching All User:
url : http://localhost:8090/api/users
 
 

6.	Adding Book:
url - http://localhost:8090/api/books
 
7.	Fetch All Books:
url - http://localhost:8090/api/books
 
 

8.	Fetch Specific book by id:
http://localhost:8080/api/books/{id} (Replace {id} with the book's ID.)
url - http://localhost:8090/api/books/1
 
 

9.	Update – Specific book 
http://localhost:8080/api/books/{id} (Replace {id} with the book's ID.)
url - http://localhost:8090/api/books/2
 
 


10.	Delete  -- Specific book  
http://localhost:8080/api/books/{id} (Replace {id} with the book's ID.)
url - http://localhost:8090/api/books/4
 

11.	Borrow a book:
http://localhost:8080/api/books/{bookId}/borrow/{userId}
url - http://localhost:8090/api/books/2/borrow/1
 
 

12.	Return Book:
http://localhost:8080/api/books/{bookId}/return (Replace {bookId} with the book's ID.)
url - http://localhost:8090/api/books/2/return
 
 








