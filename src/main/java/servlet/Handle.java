package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import daoimpl.UserDaoImpl;
import models.User;

/**
 * Servlet implementation class Handle
 */
@WebServlet("/Handle")
public class Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Handle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String action=request.getParameter("action");
		System.out.println("Password  :"+password);
		System.out.println("Action :"+action);
		
		Integer id=null;
		
		User user=null;
		switch (action) {
		case "signup":
			user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
		  id=userDao.addUser(user);
			
			if(id >0) {
				System.out.println("Added successfully...");
				response.sendRedirect("login.jsp");
			}
			
		break;
		
		case "login": 
	
			try {
				id=userDao.getUserIdByEmailAndPass(email, password);
				if(id !=null) {
					System.out.println("UserID:"+id);
					   user=userDao.getUserById(id);
					   System.out.println(user.getName());
					   HttpSession session = request.getSession();
						session.setAttribute("user", user);
					response.sendRedirect("home.jsp");
					} else {
						response.getWriter().print("Email & Password incorrect");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  break;
		  
		case "logout": 
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		  break;
			
      }
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
