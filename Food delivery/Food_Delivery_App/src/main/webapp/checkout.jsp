<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.food.Model.Cart"%>
<%@ page import="com.food.Model.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");

System.out.println("Checkout Session : " + session.getId());
System.out.println("User = " + user);
if(user == null){
    response.sendRedirect("login.html");
    return;
}

Cart cart = (Cart) session.getAttribute("cart");

if(cart == null || cart.getItems().isEmpty()){
    response.sendRedirect("cart.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Checkout</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI';
}

body{

background:#f4f4f4;

}

.container{

width:500px;
margin:50px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0 0 20px rgba(0,0,0,.15);

}

h2{

text-align:center;
margin-bottom:25px;
color:#fc8019;

}

label{

display:block;
margin-top:18px;
font-weight:bold;

}

input,textarea{

width:100%;
padding:12px;
margin-top:8px;
border:1px solid #ccc;
border-radius:6px;

}

textarea{

height:100px;

}

.total{

margin-top:25px;
font-size:24px;
font-weight:bold;
color:#fc8019;

}

button{

width:100%;
padding:15px;
margin-top:30px;
border:none;
background:#fc8019;
color:white;
font-size:18px;
border-radius:8px;
cursor:pointer;

}

button:hover{

background:#e56d00;

}

</style>

</head>

<body>

<div class="container">

<h2>Checkout</h2>

<form action="CheckoutServlet" method="post">

<label>Name</label>

<input
type="text"
name="name"
value="<%=user.getUsername()%>"
readonly>

<label>Email</label>

<input
type="email"
name="email"
value="<%=user.getEmail()%>"
readonly>

<label>Delivery Address</label>

<textarea
name="address"><%=user.getAddress()%></textarea>

<div class="total">

Grand Total :
₹<%=cart.getGrandTotal()%>

</div>

<button>

Place Order

</button>

</form>

</div>

</body>
</html>