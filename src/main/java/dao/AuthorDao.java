package dao;

import java.util.List;

import models.Author;


public interface AuthorDao {
	public Integer addAuthor(Author author);

	public Integer updateAuthor(Author author);

	public Integer deleteAuthor(Author author);

	public Author getAuthorById(int authorId);

	public List<Author> getallAuthors();
	
	
	public Author getAuthorByName(String authorName);

}
