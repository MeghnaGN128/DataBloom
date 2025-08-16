<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Army Management</title>
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
        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            gap: 18px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-weight: 500;
            padding: 6px 10px;
            border-radius: 4px;
            transition: background 0.3s;
        }
        nav ul li a:hover {
            background: rgba(255,255,255,0.2);
        }

        /* Main content */
        .container {
            max-width: 900px;
            margin: 60px auto;
            text-align: center;
            padding: 40px;
            background: #f9f9f9; /* Light gray content background */
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.05);
        }
        .container h2 {
            margin-bottom: 25px;
            color: #4facfe;
        }
        .container a {
            display: inline-block;
            padding: 12px 24px;
            margin: 8px;
            background: linear-gradient(45deg, #87cefa, #4facfe); /* Light sky blue gradient button */
            color: white;
            font-size: 15px;
            font-weight: bold;
            text-decoration: none;
            border-radius: 6px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        .container a:hover {
            transform: translateY(-3px);
            box-shadow: 0px 6px 12px rgba(0,0,0,0.18);
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

        /* Responsive */
        @media (max-width: 600px) {
            nav {
                flex-direction: column;
                align-items: flex-start;
            }
            nav ul {
                flex-direction: column;
                gap: 10px;
            }
            .container {
                margin: 30px 15px;
                padding: 20px;
            }
        }
    </style>
</head>
<body>

<nav>
    <h1>Army Management</h1>
    <ul>
        <li><a href="enter">Enter Details</a></li>
        <li><a href="featchAll">View All Data</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
</nav>

<div class="container">
    <h2>Welcome to Army Management</h2>
    <a href="enter">Go to Army Details</a>
    <a href="featchAll">Go to Get All Data</a>
</div>

<footer>
    &copy; 2025 Army Management System | All Rights Reserved
</footer>

</body>
</html>
