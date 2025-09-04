<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login With OTP</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f4f6f9;
            color: #333;
        }
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: linear-gradient(90deg, #005fa3, #0077cc);
            padding: 12px 25px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.25);
        }
        .logo img { height: 50px; }
        .menu { display: flex; gap: 20px; }
        .menu a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 15px;
            transition: color 0.3s ease, transform 0.2s ease;
        }
        .menu a:hover { color: #ffcc00; transform: scale(1.05); }

        main {
            max-width: 400px;
            margin: 100px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        main h2 {
            font-size: 26px;
            margin-bottom: 20px;
            color: #0077cc;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #0077cc;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            border-radius: 6px;
            padding: 12px 0;
            font-size: 16px;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover { background: #005fa3; }

        .error { color: red; font-size: 14px; margin-bottom: 15px; }
        footer {
            background: #111;
            color: #ccc;
            text-align: center;
            padding: 15px;
            position: fixed;
            bottom: 0;
            width: 100%;
            font-size: 14px;
            box-shadow: 0 -2px 6px rgba(0,0,0,0.25);
        }
        footer p { margin: 0; }
    </style>
</head>
<body>

<nav>
    <div class="logo">
        <img src="images/log.jpg" alt="Logo">
    </div>
    <div class="menu">
        <a href="home">Home</a>
        <a href="register">Register</a>
        <a href="login">Login</a>
    </div>
</nav>

<main>
    <h2>Login with OTP</h2>

    <% if (request.getAttribute("message") != null) { %>
    <p class="error"><%= request.getAttribute("message") %></p>
    <% } %>

    <form method="post" action="checkLogin">
        <input type="email" name="email" placeholder="Email" value="${email}" required/>
        <input type="number" name="otp" placeholder="OTP" required/>
        <input type="submit" value="Login"/>
    </form>
</main>

<footer>
    <p>&copy; 2025 User Management | All Rights Reserved</p>
</footer>

</body>
</html>
