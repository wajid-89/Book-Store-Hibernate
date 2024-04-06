package dao;

import java.util.List;


import models.Book;

public interface BookDao {
	
public Integer addBook(Book book);

public Integer updateAuthor(Book book);

public Integer deleteAuthor(Book book);

public Book getBookById(int bookId);

public List<Book> getallBooks();
}
