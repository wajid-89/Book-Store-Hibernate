package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDao;
import dao.BookDao;
import daoimpl.AuthorDaoImpl;
import daoimpl.BookDaoImpl;
import models.Author;
import models.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDao bookDaoImpl=new BookDaoImpl();
     AuthorDao authorDao=new AuthorDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String code=request.getParameter("book-code");
		String category=request.getParameter("category");
		
		String author=request.getParameter("author");
		String action=request.getParameter("action");
		
		System.out.println("Author :"+author);
		System.out.println("Code :"+code);
		System.out.println("Action :"+action);
		
		
		if(action.equals("add")) {
			Author authorId=authorDao.getAuthorByName(author);
			System.out.println(author);
			
			
			
			Book book=new Book();
			book.setName(name);
			book.setCode(code);
			book.setAuthor(authorId);
			book.setCategory(category);
		Integer row=	bookDaoImpl.addBook(book);
		System.out.println(row);
			if(row>0) {
				System.out.println("successfully added..");
				response.sendRedirect("view_book.jsp");
			}
		}
		else if(action.equals("update")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			
		Book book=bookDaoImpl.getBookById(id);
			System.out.println(author);
			
			Author author1=authorDao.getAuthorByName(author);
			
			
			book.setName(name);
			book.setCode(code);
			book.setAuthor(author1);
			book.setCategory(category);
		Integer row=	bookDaoImpl.updateAuthor(book);
		System.out.println(row);
			if(row>0) {
				System.out.println("successfully added..");
				response.sendRedirect("view_book.jsp");
			}
		}
		else if(action.equals("delete")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			
		Book book=bookDaoImpl.getBookById(id);
			
		Integer row=	bookDaoImpl. deleteAuthor(book);
		System.out.println(row);
			if(row>0) {
				System.out.println("successfully added..");
				response.sendRedirect("view_book.jsp");
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
