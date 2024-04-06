package dao;

import java.sql.SQLException;
import java.util.List;

import models.User;

public interface UserDao {
	public Integer addUser(User user);

	public Integer updateUser(User user);

	public Integer deleteUser(User user);

	public User getUserById(int userId);

	public List<User> getallUser();
	
	public Integer getUserIdByEmailAndPass(String  email,String  pss) throws SQLException;
}
