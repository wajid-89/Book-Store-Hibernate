<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="models.*"%>
<%@ page import="dao.*"%>
<%@ page import="daoimpl.*"%>
<%@ page import="java.util.*"%>
<%
session = request.getSession();
User user = (User) session.getAttribute("user");
AuthorDao authorDao = new AuthorDaoImpl();
List<Author> list = authorDao.getallAuthors();
if (user != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW AUTHORS</title>
<%@ include file="header.jsp"%>
<style>
.center-table {
	margin: auto;
}
</style>
</head>
<body style="background-color: #C0C0C0;">

		
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
			<div class="right-div">
				<a href="home.jsp" class="btn btn-primary pull-right"
					style="font-size: 20px;"><i class="fa fa-home">Home</i></a>
			</div>

				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</div>

			<div class="right-div">
				<a href="Handle?action=<%="logout"%>" class="btn btn-danger pull-right"
					style="font-size: 20px;"><i class="fa fa-sign-out-alt">Log Out</i></a>
			</div>
		</div>
	</div>
	<div class="container">
	
		<div class="container">
			<div class="row">
				<div class="col">
					<h1 class="text-center" style="font-family: cursive;">Authors</h1>
					<hr>
				</div>
			</div>
		</div>
		
		<br> <a href="add_author.jsp" class="btn btn-success"><i
			class="fas fa-plus"> Add New</i></a>

		<table class="table center-table">
			<%
			if (list.size() > 0) {
			%>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>No of Books</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<%for(Author author: list){ %>
				<tr style="font-size: 20px;">
					<td><%=author.getId() %></td>
					<td><%=author.getName() %></td>
					<td><%=author.getNoOfBooks() %></td>
					
					<td><a href="update_author.jsp?id=<%=author.getId() %>" class="btn btn-primary"><i
							class="fas fa-edit"> Update</i></a> 
							
							<a href="AuthorServlet?id=<%=author.getId() %>&&action=<%="delete" %>"
						class="btn btn-danger"><i class="fas fa-trash-alt">
								Delete</i></a></td>
				</tr>
<%} %>
				<!-- Add more rows as needed -->
			</tbody>
		</table>
		<%
		} else {
		%>
		<center>
			<h1>No Books</h1>
		</center>
		<%
		}
		%>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>