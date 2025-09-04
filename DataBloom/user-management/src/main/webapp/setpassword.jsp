<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Set Password</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f4f6f9;
            color: #333;
        }

        /* Navbar */
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

        /* Main Box */
        main {
            max-width: 400px;
            margin: 100px auto 120px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        main h2 {
            font-size: 28px;
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

        .error {
            color: red;
            font-size: 14px;
            margin-bottom: 15px;
        }

        /* Footer */
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

<!-- Navbar -->
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

<!-- Main Content -->
<main>
    <h2>Set Your Password</h2>

    <% if (request.getAttribute("message") != null) { %>
    <p class="error"><%= request.getAttribute("message") %></p>
    <% } %>

    <form method="post" action="savePassword">
        <input type="hidden" name="email" value="${email}"/>
        <input type="password" name="password" placeholder="Enter Password" required/>
        <input type="password" name="confirmPassword" placeholder="Confirm Password" required/>
        <input type="submit" value="Save Password"/>
    </form>
</main>


<footer>
    <p>&copy; 2025 User Management | All Rights Reserved</p>
</footer>

<script>
    // Frontend check for confirm password
    document.querySelector("form").onsubmit = function(e) {
        let pass = document.querySelector("input[name=password]").value;
        let cpass = document.querySelector("input[name=confirmPassword]").value;
        if(pass !== cpass) {
            alert("Passwords do not match!");
            e.preventDefault();
        }
    };
</script>

</body>
</html>
