package daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.AuthorDao;
import models.Author;

import util.Database;

public class AuthorDaoImpl implements AuthorDao{

	@Override
	public Integer  addAuthor(Author author) {
		Integer row=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(author);
			row=1;
			transaction.commit();
			System.out.println("Successfully updated.");
            session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateAuthor(Author author) {
		Integer row=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
		session.update(author);
			row=1;
			transaction.commit();
			System.out.println("Successfully updated.");
            session.close();
		} catch (Exception e) {
			e.printStackTrace();
	}
		return row;
		}

	@Override
	public Integer deleteAuthor(Author author) {
		Integer row=null;
		try {
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.remove(author);
			row=1;
			transaction.commit();
			System.out.println("Successfully updated.");
            session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return row;
	}

	@Override
	public Author getAuthorById(int authorId) {
		Author author =null;
		try {
			
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			author = session.get(Author.class, authorId);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return author;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getallAuthors() {
List<Author> list=new ArrayList<Author>();
		    try {
			
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			list=session.createQuery("From Author").list();

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public Author getAuthorByName(String authorName) {
		Author author = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("From Author a where a.name=:n");
			query.setParameter("n", authorName);
			author = (Author)query.getSingleResult();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return author;
	}

}
