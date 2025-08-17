<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>Find By ID</title>
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
            font-size: 24px;
            font-weight: bold;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
        }

        /* FORM CONTAINER */
        .form-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            text-align: center;
        }

        .form-container input[type="number"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-container input[type="submit"] {
            background-color: #004080;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0066cc;
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
            box-shadow: 0 -2px 6px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>

<body>

<header>
    Tourism Management System - Find Tour By ID
</header>

<div class="form-container">
    <form action="findByID" method="post">
        <label for="id"><strong>Enter Tour ID:</strong></label><br>
        <input type="number" name="id" id="id" required><br>
        <input type="submit" value="Get Value">
    </form>
</div>

<footer>
    &copy; 2025 Tourism Management System | All Rights Reserved
</footer>

</body>
</html>
