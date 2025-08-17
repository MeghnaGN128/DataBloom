<html>
<head>
    <title>Tourism Index</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background-color: #eef2f5;
            color: #333;
            margin: 0;
            padding: 0;
        }

        /* HEADER */
        header {
            background: linear-gradient(90deg, #004080, #0066cc);
            padding: 20px 0;
            text-align: center;
            color: white;
            font-size: 26px;
            font-weight: bold;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }

        /* MAIN CONTAINER */
        .main-container {
            max-width: 600px;
            margin: 100px auto;
            text-align: center;
        }

        .main-container h2 {
            color: #004080;
            margin-bottom: 30px;
        }

        .main-container a {
            display: block;
            margin: 15px 0;
            font-size: 18px;
            color: #004080;
            text-decoration: none;
            font-weight: bold;
        }

        .main-container a:hover {
            text-decoration: underline;
        }

        /* FOOTER */
        footer {
            background: linear-gradient(90deg, #004080, #0066cc);
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

<header>
    Tourism Management System
</header>

<div class="main-container">
    <h2>Welcome to tourism website</h2>

    <a href="redirectToTourism">Save Tourism Data</a>
    <a href="fetchAll">Get All Tourism Data</a>
    <a href="redirectToFind">Find Package</a>
</div>

<footer>
    &copy; 2025 Tourism Management System | All Rights Reserved
</footer>

</body>
</html>
