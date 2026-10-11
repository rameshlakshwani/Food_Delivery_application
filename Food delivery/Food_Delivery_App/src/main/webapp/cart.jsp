<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="com.food.Model.Cart"%>
<%@ page import="com.food.Model.CartItem"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Cart</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{

background:#1f1f2e;
color:white;

}

.header{

width:90%;
margin:40px auto 20px;

}

.header h1{

font-size:45px;

}

.header p{

color:#bdbdbd;
margin-top:8px;

}

.container{

width:92%;
margin:auto;

}

table{

width:100%;
border-collapse:collapse;
background:#2b2b3d;
border-radius:15px;
overflow:hidden;

}

th{

padding:18px;
font-size:18px;
color:#d5d5d5;
border-bottom:1px solid rgba(255,255,255,.15);

}

td{

padding:20px;
text-align:center;

}

.price{

color:#ff8b8b;
font-weight:bold;
font-size:18px;

}

.total-price{

color:#ff8b8b;
font-weight:bold;
font-size:18px;

}

.qty-box{

display:flex;
justify-content:center;
align-items:center;
gap:15px;

}

.qty-box form{

display:inline;

}

.qty-btn{

width:36px;
height:36px;
border-radius:50%;
border:none;
background:#ffd369;
font-size:22px;
font-weight:bold;
cursor:pointer;

}

.qty-btn:hover{

background:#ffc247;

}

.qty-number{

font-size:22px;
font-weight:bold;

}

.remove-btn{

padding:10px 22px;
border:2px solid #ff7b7b;
background:transparent;
color:#ff7b7b;
border-radius:30px;
cursor:pointer;
transition:.3s;

}

.remove-btn:hover{

background:#ff7b7b;
color:white;

}

.bottom{

margin-top:40px;
display:flex;
justify-content:space-between;
align-items:flex-start;
flex-wrap:wrap;

}

.add-btn{

padding:15px 35px;
background:transparent;
border:2px solid #ff7b7b;
color:#ff7b7b;
border-radius:35px;
cursor:pointer;
font-size:16px;

}

.add-btn:hover{

background:#ff7b7b;
color:white;

}

.summary{

text-align:right;

}

.summary h2{

font-size:35px;
margin-bottom:20px;

}

.checkout{

padding:16px 45px;
background:linear-gradient(to right,#ff8c42,#ffc371);
border:none;
color:white;
font-size:18px;
border-radius:35px;
cursor:pointer;

}

.checkout:hover{

opacity:.9;

}

.empty{

text-align:center;
font-size:40px;
margin-top:120px;

}

.empty a{

display:inline-block;
margin-top:30px;
padding:15px 35px;
background:#ff8c42;
color:white;
text-decoration:none;
border-radius:30px;

}

@media(max-width:900px){

table{

display:block;
overflow-x:auto;

}

.bottom{

flex-direction:column;
gap:30px;

}

.summary{

text-align:left;

}

}

</style>

</head>

<body>

<div class="header">

<h1>Your Cart</h1>

<p>Review your selected food items</p>

</div>

<div class="container">

<%

Cart cart=(Cart)session.getAttribute("cart");

if(cart==null || cart.getItems().isEmpty()){

%>

<div class="empty">

🛒 Your Cart is Empty

<br><br>

<a href="callRestaurantServlet">

Browse Restaurants

</a>

</div>

<%

}else{

%>

<table>

<tr>

<th>Item</th>

<th>Price</th>

<th>Total</th>

<th>Quantity</th>

<th>Action</th>

</tr>

<%

for(Map.Entry<Integer,CartItem> entry:cart.getItems().entrySet()){

CartItem item=entry.getValue();

%>

<tr>

<td>

<%=item.getName()%>

</td>

<td class="price">

₹<%=item.getPrice()%>

</td>

<td class="total-price">

₹<%=item.getTotalPrice()%>

</td>

<td>

<div class="qty-box">

<!-- Minus -->

<form action="CartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menuId"
value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId"
value="<%=item.getRestaurantId()%>">

<input type="hidden" name="quantity"
value="<%=item.getQuantity()-1%>">

<button class="qty-btn">-</button>

</form>

<span class="qty-number">

<%=item.getQuantity()%>

</span>

<!-- Plus -->

<form action="CartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menuId"
value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId"
value="<%=item.getRestaurantId()%>">

<input type="hidden" name="quantity"
value="<%=item.getQuantity()+1%>">

<button class="qty-btn">+</button>

</form>

</div>

</td>

<td>

<form action="CartServlet" method="post">

<input type="hidden" name="action" value="delete">
<input type="hidden" name="menuId"
value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId"
value="<%=item.getRestaurantId()%>">

<button class="remove-btn">

Remove

</button>

</form>

</td>

</tr>

<%

}

%>

</table>

<div class="bottom">

<div>

<a href="callRestaurantServlet">

<button class="add-btn">

← Add More Items

</button>

</a>

</div>

<div class="summary">

<h2>

Grand Total : ₹<%=cart.getGrandTotal()%>

</h2>

<form action="checkout.jsp">

<button class="checkout">

Proceed To Checkout →

</button>

</form>

</div>

</div>

<%

}

%>

</div>

</body>

</html>