<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Replace Cart</title>

<style>

body{

font-family:Segoe UI;
background:rgba(0,0,0,.45);

display:flex;
justify-content:center;
align-items:center;

height:100vh;

margin:0;

}

.box{

background:white;
padding:35px;
width:420px;
border-radius:12px;
text-align:center;

}

h2{

color:#fc8019;

}

p{

margin:25px 0;
font-size:17px;

}

.buttons{

display:flex;
justify-content:space-between;

}

button{

padding:12px 25px;
border:none;
cursor:pointer;
font-size:16px;
border-radius:8px;

}

.cancel{

background:#ddd;

}

.continue{

background:#fc8019;
color:white;

}

</style>

</head>

<body>

<div class="box">

<h2>Replace Cart?</h2>

<p>

Your cart contains items from another restaurant.

Do you want to clear the current cart and add items from this restaurant?

</p>

<div class="buttons">

<form action="cart.jsp">

<button class="cancel">

Cancel

</button>

</form>

<form action="ReplaceCartServlet">

<button class="continue">

Yes, Start New Cart

</button>

</form>

</div>

</div>

</body>

</html>