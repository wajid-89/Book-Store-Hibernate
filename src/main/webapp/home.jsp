<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.*" %>
    <%
    session=request.getSession();
    User user=(User) session.getAttribute("user");
    if(user != null){
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<%@include file="header.jsp" %>
 <style type="text/css">
   body {
    font-family: Arial, sans-serif;
    background-color: #008080;
    margin: 24px;
    padding: 0;
   
    
  }

  .button-container {
    text-align: center;
  }

  .button-list {
    list-style-type: none;
    padding: 0;
  }

  .button {
    display: inline-block;
    padding: 10px 100px; /* Increased padding to increase button length */
    margin: 5px;
    font-size: 16px;
    cursor: pointer;
    border: none;
    border-radius: 5px;
    background-color: green;
    color: white;
    text-decoration: none;
    transition: background-color 0.3s;
    line-height: 30px; /* Center button text vertically */
  }

  .button:hover {
    background-color: #0056b3;
  }

  @media (max-width: 768px) {
    .button {
      padding: 8px 20px; /* Adjusted padding for smaller screens */
      font-size: 14px;
    }
  }
  </style>
</head>
<body  >
<div class="container">
    <div class="row">
        <div class="col">
            <h1 class="text-center" style="color: white;">Welcome <%=user.getName() %> to Home Page</h1>
            <hr>
        </div>
    </div>
    </div>
    <br>
<div class="button-container" >

  <ul class="button-list">
    <li><a href="view_author.jsp"> <button class="button">Author </button></a></li>
     <li><a href="view_book.jsp"> <button class="button">Books </button></a></li>
   <li><a href="Handle?action=<%="logout"%>"> <button class="button">Log Out </button></a></li>
  </ul>
</div>

</body>
</html>
<%}else{
response.sendRedirect("login.jsp");
}%>