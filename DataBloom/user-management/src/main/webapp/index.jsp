<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Management</title>
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

        /* Logo left */
        .logo img {
            height: 50px;
        }

        /* Right menu */
        .menu {
            display: flex;
            gap: 20px;
        }
        .menu a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 15px;
            transition: color 0.3s ease, transform 0.2s ease;
        }
        .menu a:hover {
            color: #ffcc00;
            transform: scale(1.05);
        }

        /* Main content */
        main {
            text-align: center;
            padding: 80px 20px;
        }
        main h2 {
            font-size: 28px;
            margin-bottom: 10px;
            color: #0077cc;
        }
        main p {
            font-size: 16px;
            margin-bottom: 25px;
            color: #555;
        }
        main a {
            display: inline-block;
            margin: 10px;
            padding: 12px 30px;
            background: #0077cc;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        main a:hover {
            background: #005fa3;
            transform: translateY(-3px);
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
        footer p {
            margin: 0;
        }
    </style>
</head>
<body>

<nav>
    <div class="logo">
        <img src="images/log.jpg" alt="Logo" style="height:50px">
    </div>
    <div class="menu">
        <a href="register">Register</a>
        <a href="login">Login</a>
    </div>
</nav>


<main>
    <h1>Welcome! to user-management application</h1>

</main>


<footer>
    <p>&copy; 2025 User Management | All Rights Reserved</p>
</footer>

</body>
</html>
