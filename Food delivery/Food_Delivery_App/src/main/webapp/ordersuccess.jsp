<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Order Successful</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#ff6a00,#ffb347);

}

.success-card{

    width:550px;
    background:white;
    padding:50px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 15px 40px rgba(0,0,0,.25);

}

.icon{

    width:120px;
    height:120px;
    margin:auto;
    border-radius:50%;
    background:#28a745;
    color:white;
    font-size:65px;
    display:flex;
    justify-content:center;
    align-items:center;

}

h1{

    margin-top:25px;
    color:#28a745;
    font-size:40px;

}

.message{

    margin-top:18px;
    color:#555;
    font-size:18px;
    line-height:30px;

}

.order-id{

    margin-top:25px;
    padding:15px;
    background:#fff4e8;
    border-radius:10px;
    color:#fc8019;
    font-size:20px;
    font-weight:bold;

}

.buttons{

    margin-top:35px;
    display:flex;
    justify-content:center;
    gap:20px;

}

.btn{

    padding:14px 30px;
    border:none;
    border-radius:8px;
    font-size:17px;
    cursor:pointer;
    text-decoration:none;
    font-weight:bold;
    transition:.3s;

}

.home{

    background:#fc8019;
    color:white;

}

.home:hover{

    background:#e56d00;

}

.orders{

    background:#28a745;
    color:white;

}

.orders:hover{

    background:#218838;

}

</style>

</head>

<body>

<div class="success-card">

    <div class="icon">

        ✓

    </div>

    <h1>

        Order Placed Successfully!

    </h1>

    <p class="message">

        Thank you for ordering with <b>Foodie</b>.<br>

        Your delicious food is being prepared and will be delivered shortly.

    </p>

    <div class="order-id">

        Order Status : Confirmed

    </div>

    <div class="buttons">

        <a href="callRestaurantServlet" class="btn home">

            Order More Food

        </a>

        <form action="OrderHistoryServlet" method="get">
    <button type="submit">View Orders</button>
</form>

    </div>

</div>

</body>
</html>