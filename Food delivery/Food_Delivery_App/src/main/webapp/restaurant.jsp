<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.food.Model.Restaurant"%>
<%@ page import="com.food.Model.User"%>
<%
User user = (User) session.getAttribute("loggedInUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Foodie - Restaurants</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#f8f8f8;
}

/* Navbar */

.navbar{
    height:80px;
    background:white;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 80px;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
    position:sticky;
    top:0;
    z-index:1000;
}

.logo{
    font-size:32px;
    font-weight:bold;
    color:#fc8019;
}

.nav-links{
    display:flex;
    gap:30px;
}

.nav-links a{
    text-decoration:none;
    color:#333;
    font-weight:600;
    transition:0.3s;
}

.nav-links a:hover{
    color:#fc8019;
}

.buttons button{
    padding:10px 20px;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-weight:bold;
}

.login{
    background:white;
    border:2px solid #fc8019;
    color:#fc8019;
}

.signup{
    background:#fc8019;
    color:white;
}

.buttons{
    display:flex;
    align-items:center;
    gap:15px;
}

.buttons a{
    text-decoration:none;
    padding:10px 20px;
    border-radius:8px;
    font-weight:bold;
}

.logout{
    background:#e53935;
    color:white;
    text-decoration:none;
    padding:10px 20px;
    border-radius:8px;
    font-weight:bold;
    margin-left:10px;
}

.logout:hover{
    background:#c62828;
}

.welcome{
    font-weight:bold;
    color:#333;
}

/* Hero */

.hero{
    height:400px;
    background:url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600') center/cover;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color:white;
    text-align:center;
    position:relative;
}

.hero::before{
    content:"";
    position:absolute;
    inset:0;
    background:rgba(0,0,0,0.5);
}

.hero-content{
    position:relative;
    z-index:1;
}

.hero h1{
    font-size:55px;
    margin-bottom:15px;
}

.hero p{
    font-size:20px;
    margin-bottom:25px;
}

.search-box{
    width:600px;
    max-width:90%;
}

.search-box input{
    width:100%;
    padding:18px;
    border:none;
    border-radius:12px;
    font-size:16px;
}

/* Categories */

.categories{
    padding:40px 80px;
}

.categories h2{
    margin-bottom:20px;
}

.category-list{
    display:flex;
    gap:20px;
    flex-wrap:wrap;
}

.category{
    background:white;
    padding:15px 25px;
    border-radius:30px;
    box-shadow:0 2px 8px rgba(0,0,0,0.1);
    cursor:pointer;
    transition:0.3s;
}

.category:hover{
    background:#fc8019;
    color:white;
}

/* Restaurants */

.restaurants{
    padding:20px 80px 60px;
}

.restaurants h2{
    margin-bottom:25px;
    font-size:32px;
}

.restaurant-grid{
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(320px,1fr));
    gap:30px;
}

.card{
    background:white;
    border-radius:18px;
    overflow:hidden;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
    transition:0.4s;
}

.card:hover{
    transform:translateY(-10px);
}

.image-box{
    position:relative;
}

.image-box img{
    width:100%;
    height:230px;
    object-fit:cover;
}

.offer{
    position:absolute;
    bottom:10px;
    left:10px;
    background:#e53935;
    color:white;
    padding:8px 12px;
    border-radius:8px;
    font-size:13px;
    font-weight:bold;
}

.rating{
    position:absolute;
    top:10px;
    right:10px;
    background:#16a34a;
    color:white;
    padding:6px 10px;
    border-radius:8px;
    font-size:14px;
    font-weight:bold;
}

.content{
    padding:18px;
}

.content h3{
    margin-bottom:8px;
    color:#222;
}

.cuisine{
    color:gray;
    margin-bottom:12px;
}

.info{
    display:flex;
    justify-content:space-between;
    font-size:15px;
    color:#555;
}

.footer{
    background:#111;
    color:white;
    text-align:center;
    padding:25px;
    margin-top:40px;
}
</style>
</head>

<body>

<!-- Navbar -->

<nav class="navbar">
    <div class="logo">🍔 Foodie</div>

    <div class="nav-links">
        <a href="#">Home</a>
        <a href="#">Restaurants</a>
        <a href="#">Offers</a>
        <a href="#">Cart</a>
        <a href="#">Profile</a>
    </div>

		<div class="buttons">

			<a href="login.html" class="login">Login</a> 
			<a href="register.html" class="signup">Sign Up</a> 
			<a href="LogoutServlet" class="logout">Logout</a>

		</div>
	</nav>

<!-- Hero -->

<section class="hero">
    <div class="hero-content">
        <h1>Discover Great Food Near You</h1>
        <p>Order from your favourite restaurants & enjoy fast delivery</p>

        <div class="search-box">
            <input type="text" placeholder="Search restaurants, cuisines or dishes...">
        </div>
    </div>
</section>

<!-- Categories -->

<section class="categories">
    <h2>Popular Categories</h2>

    <div class="category-list">
        <div class="category">🍕 Pizza</div>
        <div class="category">🍔 Burgers</div>
        <div class="category">🍛 Biryani</div>
        <div class="category">🍜 Chinese</div>
        <div class="category">🥗 Healthy</div>
        <div class="category">🍦 Desserts</div>
    </div>
</section>

<!-- Restaurants -->

<section class="restaurants">

<h2>Top Restaurants Near You</h2>

		<div class="restaurant-grid">

			<%
			List<Restaurant> allRestaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
			for (Restaurant restaurant : allRestaurants) {
			%> 
			
			<a href="menu?restaurantID=<%= restaurant.getRestaurantId() %>">
				<div class="card">
				<div class="image-box">
					<img src="<%= restaurant.getImagePath() %>" alt="Restaurant">
					<span class="offer">50% offer Upto ₹100 </span><span class="rating">★
						<%=restaurant.getRating() %></span>
				</div>
				<div class="content">
					<h3><%=restaurant.getName() %></h3>
					<p class="cuisine"><%=restaurant.getCuisineType() %></p>
					<div class="info">
						<span>📍<%= restaurant.getAddress()%></span> <span>🕒 <%=restaurant.getDeliveryTime() %></span>
					</div>
				</div>
			</div>
			</a>
				
			<% 
			       }

			%>

		
	</section>

<footer class="footer">
    © 2026 Foodie | Fast Delivery • Great Food • Happy Customers
</footer>

</body>
</html>