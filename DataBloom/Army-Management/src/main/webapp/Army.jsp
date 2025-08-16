<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Army Management Details</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #eef2f5; /* Light gray-blue background */
            color: #333;
        }

        /* Navbar */
        nav {
            background: linear-gradient(90deg, #87cefa, #4facfe); /* Light sky blue gradient */
            padding: 14px 25px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }
        nav h1 {
            margin: 0;
            font-size: 22px;
            font-weight: bold;
            color: white;
        }
        nav a {
            color: white;
            text-decoration: none;
            font-weight: 500;
        }
        nav a:hover {
            text-decoration: underline;
        }

        /* Form Container */
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            background: #f9f9f9; /* Light gray box */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.05);
        }
        .form-container h2 {
            color: #4facfe;
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container label {
            display: block;
            font-weight: 500;
            margin-bottom: 6px;
            text-align: left;
        }
        .form-container input[type="text"],
        .form-container input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 14px;
        }
        .form-container input[type="submit"] {
            background: linear-gradient(45deg, #87cefa, #4facfe);
            padding: 12px;
            color: white;
            font-size: 15px;
            font-weight: bold;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        .form-container input[type="submit"]:hover {
            transform: translateY(-2px);
            box-shadow: 0px 6px 12px rgba(0,0,0,0.18);
        }
        .form-container a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #4facfe;
            font-weight: bold;
            text-align: center;
            width: 100%;
        }
        .form-container a:hover {
            text-decoration: underline;
        }

        /* Footer */
        footer {
            background: linear-gradient(90deg, #87cefa, #4facfe);
            color: white;
            text-align: center;
            padding: 12px;
            font-size: 14px;
            position: fixed;
            bottom: 0;
            width: 100%;
            box-shadow: 0 -2px 6px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav>
    <h1>Army Management</h1>
    <a href="give">Home</a>
</nav>

<!-- Form Section -->
<div class="form-container">
    <h2>Army Management Details</h2>
    <form action="save" method="post">
        <label>Name:</label>
        <input type="text" placeholder="Enter the name" name="armyName">

        <label>Country:</label>
        <input type="text" placeholder="Enter the country" name="country">

        <label>Commander Name:</label>
        <input type="text" placeholder="Enter the commander name" name="commanderName">

        <label>Base Location:</label>
        <input type="text" placeholder="Enter the base location" name="baseLocation">

        <label>Established Date:</label>
        <input type="date" name="establishedDate">

        <input type="submit" value="Save">
        <a href="give">Go back home</a>
    </form>
</div>

<!-- Footer -->
<footer>
    &copy; 2025 Army Management System | All Rights Reserved
</footer>

</body>
</html>
