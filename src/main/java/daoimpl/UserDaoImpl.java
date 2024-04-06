package daoimpl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.UserDao;
import models.User;
import util.Database;


public class UserDaoImpl implements UserDao {

	@Override
	public Integer addUser(User user) {
	Integer row=null;
		try{
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(user);
			 row=1;
			transaction.commit();
			session.close();
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return row;
	}
 
	@Override
	public Integer updateUser(User user) {
		Integer row=null;
		try {
			
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(user);
			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteUser(User user) {
		Integer row=null;
		try {
			
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.remove(user);
			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public User getUserById(int userId) {
		User user =null;
		try {
			
			SessionFactory sessionFactory=Database.getConnection();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			user = session.get(User.class, userId);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getallUser() {
		List<User> list=new ArrayList<User>();
		try {
		SessionFactory sessionFactory=Database.getConnection();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
	    list=session.createQuery("FROM User").list();
	    transaction.commit();
	    System.out.println("Successfully saved.");
		session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer getUserIdByEmailAndPass(String email, String pss)  throws SQLException{
		Integer row=null;
		SessionFactory sessionFactory=Database.getConnection();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	
	String getByEmailQuery = "FROM User WHERE email = :uemail and password=:up";
	Query query = session.createQuery(getByEmailQuery);
	query.setParameter("uemail", email);
	query.setParameter("up", pss);
	//User user = (User) query.getSingleResult();
	List list= ((org.hibernate.query.Query) query).list();//will return the records from 5 to 10th number  
	
User user = (User) list.get(0);
row=1;
		transaction.commit();
		session.close();
		if (user != null) {
			return user.getId();
		}
		return row;
	}
}
