<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tourism Page</title>
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

        /* FORM CONTAINER */
        .form-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }

        .form-container h2 {
            margin-bottom: 20px;
        }

        .success-message {
            color: green;
        }

        .error-message {
            color: red;
        }

        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container input[type="date"] {
            width: 100%;
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
            box-shadow: 0 -2px 6px rgba(0,0,0,0.2);
        }
    </style>
</head>

<body>

<header>
    Tourism Management System - Save Package
</header>

<div class="form-container">
    <h2 class="success-message">${success}</h2>
    <h2 class="error-message">${error}</h2>

    <form action="saveData" method="post">
        Destination: <input type="text" name="destination"><br>
        Start Point: <input type="text" name="startPoint"><br>
        Package price: <input type="number" name="packagePrice"><br>
        Vehicle: <input type="text" name="vehicle"><br>
        Vehicle Number: <input type="text" name="vehicleNumber"><br>
        Number of people: <input type="number" name="noOfPeople"><br>
        Start Date: <input type="date" name="startDate"><br>
        End Date: <input type="date" name="endDate"><br>
        <input type="submit" value="Save Data">
    </form>
</div>

<footer>
    &copy; 2025 Tourism Management System | All Rights Reserved
</footer>

</body>
</html>
