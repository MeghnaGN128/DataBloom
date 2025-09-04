<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Registration</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
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
        .logo img { height: 45px; }
        .menu { display: flex; gap: 20px; }
        .menu a {
            color: #fff;
            text-decoration: none;
            font-weight: 600;
            transition: color 0.3s ease, transform 0.2s ease;
        }
        .menu a:hover { color: #ffcc00; transform: scale(1.05); }

        /* Main content */
        main {
            max-width: 700px;
            margin: 80px auto 100px;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        main h2 {
            font-size: 26px;
            margin-bottom: 20px;
            text-align: center;
            color: #0077cc;
        }

        .error {
            color: #c00;
            text-align: center;
            margin-bottom: 15px;
            font-weight: 600;
        }

        input, textarea, select {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 15px;
        }
        input[type="submit"] {
            background: #0077cc;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            padding: 14px;
            border-radius: 6px;
        }
        input[type="submit"]:hover { background: #005fa3; }

        /* Email input with circle at exact left side */
        .email-wrapper {
            position: relative;
            width: 100%;
        }
        .email-label {
            display: flex;
            align-items: center;
            width: 100%;
        }
        .email-label input[type="email"] {
            flex: 1;
            padding-right: 10px;
        }
        .verify-circle {
            margin-left: 12px;
            width: 22px;
            height: 22px;
            border: 2px solid #111;
            border-radius: 50%;
            background: #fff;
            cursor: pointer;
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            display: flex;
            align-items: center;
            justify-content: center;
            transition: all 0.3s ease;
        }
        .verify-circle:checked {
            background: #111;
            border-color: #111;
        }
        .verify-circle:checked::after {
            content: "✔";
            color: #fff;
            font-size: 14px;
            font-weight: bold;
            display: block;
            text-align: center;
            width: 100%;
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
        }
    </style>
</head>
<body>
<nav>
    <div class="logo">
        <img src="images/log.jpg" alt="Logo">
    </div>
    <div class="menu">
        <a href="home">Home</a>
        <a href="registers">Register</a>
        <a href="login">Login</a>
    </div>
</nav>

<main>
    <h2>User Registration</h2>

    <% if (request.getAttribute("message") != null) { %>
    <p class="error"><%= request.getAttribute("message") %></p>
    <% } %>

    <form method="post" action="register">
        <input type="text" name="name" placeholder="Full Name"  value="${dto.name}" required  />

        <div class="email-wrapper">
            <label class="email-label">
                <input type="email" name="email" placeholder="Email" value="${dto.email}" required />
                <input type="checkbox" class="verify-circle" id="emailVerification" name="emailVerification" required />
            </label>
        </div>

        <input type="text" name="mobile" placeholder="Mobile Number" value="${dto.mobile}" required />
        <input type="date" name="dob" required />
        <select name="gender" required>
            <option value="">Select Gender</option>
            <option>Male</option>
            <option>Female</option>
            <option>other</option>
        </select>
        <select name="state" value="${dto.state}" required>
            <option value="">Select State</option>
            <option>Karnataka</option>
            <option>Maharashtra</option>
            <option>Tamil Nadu</option>
            <option>Kerala</option>
            <option>Telangana</option>
            <option>Andhra Pradesh</option>
            <option>Other</option>
        </select>
        <textarea name="address" placeholder="Address"  value="${dto.address}" required></textarea>
        <input type="submit" value="Register"/>
    </form>
</main>

<footer>
    <p>&copy; 2025 User Management | All Rights Reserved</p>
</footer>

<script>
    // Prevent submit unless circle checked
    document.querySelector("form").onsubmit = function(e) {
        if (!document.querySelector("#emailVerification").checked) {
            alert("Please verify your email by clicking the circle.");
            e.preventDefault();
        }
    }
</script>

</body>
</html>
