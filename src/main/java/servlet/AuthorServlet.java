package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDao;
import daoimpl.AuthorDaoImpl;
import models.Author;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthorDao authorDao=new AuthorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String noOfBooks=request.getParameter("no-of-books");
		String action=request.getParameter("action");
		System.out.println("Name  :"+name);
		System.out.println("ACTION  :"+action);
		
		//Author author=null;
		
		if(action.equals("add")) {
			
	    Author author=new Author();
		author.setName(name);
		author.setNoOfBooks(noOfBooks);
		Integer row=authorDao.addAuthor(author);
		if(row >0) {
			System.out.println("Added successfully...");
			response.sendRedirect("view_author.jsp");
		}
	}
		else if(action.equals("update")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			Author author=new Author();
			author.setId(id);
			author.setName(name);
			author.setNoOfBooks(noOfBooks);
		Integer row=	authorDao.updateAuthor(author);
		//System.out.println(row);
		if(row > 0) {
			response.sendRedirect("view_author.jsp");
		}
	}
		else if(action.equals("delete")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			Author author=new Author();
			author.setId(id);
		Integer row=authorDao.deleteAuthor(author);
		//System.out.println(row);
		if(row > 0) {
			response.sendRedirect("view_author.jsp");
		}
	}	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
