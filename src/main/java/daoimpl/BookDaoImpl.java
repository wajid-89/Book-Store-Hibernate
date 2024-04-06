package daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.BookDao;
import models.Book;
import util.Database;

public class BookDaoImpl implements BookDao {

	@Override
	public Integer addBook(Book book) {
		Integer data=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 
			session.save(book);
			data = 1;
			transaction.commit();
			System.out.println("Added Successfully...");
			session.close();
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Integer updateAuthor(Book book) {
		Integer data=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 
			session.update(book);
			data = 1;
			transaction.commit();
			System.out.println("Added Successfully...");
			session.close();
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Integer deleteAuthor(Book book) {
		Integer data=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 
			session.remove(book);
			data = 1;
			transaction.commit();
			System.out.println("Added Successfully...");
			session.close();
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 
			book=session.get(Book.class,bookId);
			
			transaction.commit();
			System.out.println("Added Successfully...");
			session.close();
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> getallBooks() {
		List<Book> list=new ArrayList<Book>();
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 
			list=session.createQuery("From Book").list();
			transaction.commit();
			System.out.println("Added Successfully...");
			session.close();
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
