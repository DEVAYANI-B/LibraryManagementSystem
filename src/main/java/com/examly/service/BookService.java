package main.java.com.examly.service;

import java.util.List;
import main.java.com.examly.entity.Book;

public interface BookService{

boolean addBook(Book book);
Book getbookById(String bookId);
List<Book> getAllBooks();
boolean updateBook(Book book);
boolean deleteBook(String bookId);
List<Book> searchBookByTitle(String title);
boolean reduceBookCopy(String bookId);
boolean increaseBookCopy(String bookId);


}