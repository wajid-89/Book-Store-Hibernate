<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.*" %>
   <%@ page import="dao.*" %>
   <%@ page import="daoimpl.*" %>
    <%@ page import="java.util.*" %>
    
 <%
 session=request.getSession();
 User user=(User) session.getAttribute("user");
 AuthorDao authorDao=new AuthorDaoImpl();
 List<Author> list=authorDao.getallAuthors();
 if(user != null){
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<%@ include file="header.jsp" %>
<style type="text/css">

 body {
      background-color: #008080;
    }
    .container {
      max-width: 400px;
      margin: 50px auto;
      background-color: #DB7093;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .btn-custom {
      background-color: #007bff;
      border-color: #007bff;
    }
    .btn-custom:hover {
      background-color: #0056b3;
      border-color: #0056b3;
    }
    .form-label{
    color: white;
    font-size: 20px;
    font-family: cursive;
    }
</style>
</head>
<body>



<div class="container">
           <div class="right-div">
				<a href="view_book.jsp" class="btn btn-info  pull-right"
					style="font-size: 20px;"><i class="fa fa-arrow-left">Back</i></a>
			</div>
    <h1 class="text-center mb-4" style="color: white; font-family: cursive;">Add Book</h1>
    <form action="BookServlet?action=<%="add"%>" method="post">
      <div class="mb-3">
        <label  class="form-label">Name</label>
        <input type="text" class="form-control"  name="name">
       
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Book Code</label>
        <input type="text" class="form-control" name="book-code">
      </div>
      
      <div class="mb-3">
        <label  class="form-label">Author</label>
       
       <select class="custom-select"  name="author" >
       <optgroup label="select author">
      <%for(Author author: list){ %>
      
       <option value="<%=author.getName()%>"><%=author.getName() %></option>
      <%} %>
       </optgroup>
       </select>
      </div>
      
      <div class="mb-3">
        <label  class="form-label">Category</label>
        <input type="text" class="form-control" name="category">
      </div>
      
     <button type="reset" class="btn btn-primary btn-custom">Clear</button>
      <button type="submit" class="btn btn-primary btn-custom">Submit</button>
    </form>
  </div>


<%@ include file="footer.jsp" %>
</body>
</html>
<%
}else{
	response.sendRedirect("login.jsp");
}
%>