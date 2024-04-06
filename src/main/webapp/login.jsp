<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
body{
 background-color: #008080;
}
.login-container{
margin-top: 5%;
margin-bottom: 5%;
}
.login-form-1{
 background-color: white;
padding: 5%;
box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-1 h3{
text-align: center;
color: #333;
}
.login-form-2{
padding: 5%;
background: #0062cc;
box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-2 h3{
text-align: center;
color: #fff;
}
.login-container form{
padding: 10%;
}
.btnSubmit
{
width: 50%;
border-radius: 1rem;
padding: 1.5%;
border: none;
cursor: pointer;
}
.login-form-1 .btnSubmit{
font-weight: 600;
color: #fff;
background-color: #0062cc;
}
.login-form-2 .btnSubmit{
font-weight: 600;
color: #0062cc;
background-color: #fff;
}
</style>
</head>
<body >


<div class="container login-container">
<div class="row">
<div class="col-md-6 login-form-1">
<h3>Login  Form </h3>
<form action="Handle?action=<%="login"%>" method="post">
<div class="form-group">
<input type="email" class="form-control" placeholder="Enter Your Email " value=""  name="email"/>
</div>
<div class="form-group">
<input type="password" class="form-control" placeholder="Your Password " value="" name="password" />
</div>
<div class="form-group">
<input type="submit" class="btnSubmit" value="Login" />
</div>
</form>
</div>

<div class="col-md-6 login-form-2">
<h3>Sign Up</h3>
<form action ="Handle?action=<%="signup"%>" method="post">
<div class="form-group">
<input type="text" class="form-control" placeholder="Enter Name " value=""  name="name"/>
</div>
<div class="form-group">
<input type="email" class="form-control" placeholder="Enter Email " value=""  name="email"/>
</div>
<div class="form-group">
<input type="text" class="form-control" placeholder="Enter Password " value="" name ="password" />
</div>
<div class="form-group">
<input type="submit" class="btnSubmit" value="Sign Up" />
</div>

</form>
</div>
</div>
</div> 

</body>
</html>