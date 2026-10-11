<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.food.Model.Menu"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Menu</title>

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

/* Header */

.header{
    background:#fff;
    padding:30px 60px;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
}

.header h1{
    font-size:42px;
    color:#222;
}

.header p{
    margin-top:8px;
    color:#666;
    font-size:18px;
}

/* Section */

.menu-section{
    width:95%;
    margin:40px auto;
}

.menu-title{
    font-size:35px;
    margin-bottom:30px;
    color:#222;
}

/* GRID */

.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(300px,1fr));
    gap:30px;
    align-items:start;
}

/* CARD */

.menu-card{
    background:#fff;
    border-radius:18px;
    overflow:hidden;
    box-shadow:0 6px 18px rgba(0,0,0,.12);
    transition:.3s;
}

.menu-card:hover{
    transform:translateY(-8px);
    box-shadow:0 12px 25px rgba(0,0,0,.18);
}

/* IMAGE */

.image-box{
    position:relative;
}

.image-box img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.rating{
    position:absolute;
    top:12px;
    right:12px;
    background:#16a34a;
    color:white;
    padding:6px 12px;
    border-radius:20px;
    font-size:14px;
    font-weight:bold;
}

/* CONTENT */

.content{
    padding:18px;
}

.content h3{
    font-size:26px;
    color:#222;
    margin-bottom:8px;
}

.cuisine{
    color:#777;
    font-size:16px;
    margin-bottom:12px;
}

.description{
    color:#555;
    line-height:1.6;
    font-size:15px;
    height:70px;
    overflow:hidden;
}

/* PRICE */

.price-row{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin:18px 0;
}

.price{
    color:#fc8019;
    font-size:24px;
    font-weight:bold;
}

.status{
    background:#dcfce7;
    color:#15803d;
    padding:6px 12px;
    border-radius:20px;
    font-size:14px;
    font-weight:600;
}

/* INFO */

.info{
    display:flex;
    justify-content:space-between;
    color:#666;
    font-size:15px;
    margin-top:15px;
}

/* BUTTON */

.add-btn{
    width:100%;
    margin-top:20px;
    padding:12px;
    background:#fc8019;
    color:white;
    border:none;
    border-radius:10px;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

.add-btn:hover{
    background:#e46d08;
}

@media(max-width:768px){

.header{
    padding:20px;
}

.menu-section{
    width:92%;
}

.header h1{
    font-size:32px;
}

.menu-title{
    font-size:28px;
}

}

</style>

</head>

<body>

<div class="header">
    <h1>Paradise Biryani</h1>
    <p>Biryani • Chinese • Fast Food • Desserts</p>
</div>

<section class="menu-section">

<h2 class="menu-title">Recommended Items</h2>

<div class="menu-grid">

<%
List<Menu> allMenusByRestaurant=(List<Menu>)request.getAttribute("allMenusByRestaurant");

if(allMenusByRestaurant!=null){
for(Menu menu:allMenusByRestaurant){
%>

<div class="menu-card">

    <div class="image-box">
        <img src="<%=menu.getImagePath()%>" alt="<%=menu.getItemName()%>">
        <span class="rating">★ 4.7</span>
    </div>

    <div class="content">

        <h3><%=menu.getItemName()%></h3>

        <p class="cuisine"><%=menu.getCategory()%></p>

        <p class="description">
            <%=menu.getDescription()%>
        </p>

        <div class="price-row">
            <span class="price">₹<%=menu.getPrice()%></span>
            <span class="status">
                <%=menu.isAvailable() ? "Available" : "Out of Stock"%>
            </span>
        </div>

        <div class="info">
            <span>⭐ <%=menu.getRating()%></span>
            <span>🕒 <%=menu.getDeliveryTime()%>  
            
            </span>
        </div>
        
        <form action="CartServlet">
        	<input type="hidden" name="menuId" value="<%=menu.getMenuId() %>">
        	<input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId() %>">
        	<input type="hidden" name="quantity" value="1">
        	<input type="hidden" name="action" value="add">
        	<button class="add-btn">Add to Cart</button>
        </form>

        

    </div>

</div>

<%
}
}
%>

</div>

</section>

</body>
</html>