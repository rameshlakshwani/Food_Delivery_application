<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.food.Model.OrderTable"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Orders</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{
background:#f5f5f5;
}

.header{
background:#fc8019;
color:white;
padding:25px;
text-align:center;
}

.container{
width:90%;
margin:40px auto;
}

.order-card{
background:white;
border-radius:12px;
padding:25px;
margin-bottom:25px;
box-shadow:0 5px 15px rgba(0,0,0,.15);
}

.row{
display:flex;
justify-content:space-between;
margin:12px 0;
font-size:18px;
}

.label{
font-weight:bold;
color:#444;
}

.value{
color:#fc8019;
font-weight:bold;
}

.status{
background:#28a745;
color:white;
padding:6px 15px;
border-radius:20px;
}

.btn{

display:inline-block;
margin-top:20px;
padding:12px 25px;
background:#fc8019;
color:white;
text-decoration:none;
border-radius:8px;

}

.empty{

text-align:center;
margin-top:150px;
font-size:35px;
color:gray;

}

</style>

</head>

<body>

<div class="header">

<h1>My Orders</h1>

</div>

<div class="container">

<%

List<OrderTable> orders =
(List<OrderTable>)request.getAttribute("orders");

if(orders==null || orders.isEmpty()){

%>

<div class="empty">

No Orders Found

<br><br>

<a href="callRestaurantServlet" class="btn">

Order Food

</a>

</div>

<%

}else{

for(OrderTable order : orders){

%>

<div class="order-card">

<div class="row">

<span class="label">Order ID</span>

<span class="value">
#<%=order.getOrderId()%>
</span>

</div>

<div class="row">

<span class="label">Restaurant ID</span>

<span>
<%=order.getRestaurantId()%>
</span>

</div>

<div class="row">

<span class="label">Order Date</span>

<span>
<%=order.getOrderDate()%>
</span>

</div>

<div class="row">

<span class="label">Payment</span>

<span>
<%=order.getPaymentMethod()%>
</span>

</div>

<div class="row">

<span class="label">Status</span>

<span class="status">
<%=order.getStatus()%>
</span>

</div>

<div class="row">

<span class="label">Grand Total</span>

<span class="value">
₹<%=order.getTotalAmount()%>
</span>

</div>

<a href="callRestaurantServlet" class="btn">

Order Again

</a>

</div>

<%

}

}

%>

</div>

</body>

</html>