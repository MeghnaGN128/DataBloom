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
            font-size: 24px;
            font-weight: bold;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }

        /* FORM WRAPPER */
        .form-container {
            max-width: 500px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            border-radius: 8px;
        }

        .form-container h2 {
            color: #004080;
            margin-bottom: 20px;
        }

        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container input[type="date"] {
            width: 100%;
            padding: 8px 10px;
            margin: 6px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-container input[type="submit"] {
            background-color: #004080;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0066cc;
        }

        .form-container a {
            display: inline-block;
            margin-top: 15px;
            color: #004080;
            text-decoration: none;
            font-weight: bold;
        }

        .form-container a:hover {
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
    Tourism Management System - Update Package
</header>

<div class="form-container">
    <h2>Update Tourism Data</h2>

    <form action="updateTourism" method="post">
        Tour ID: <input type="number" name="tourID" value="${ref.tourID}" readonly><br>
        Destination: <input type="text" name="destination" value="${ref.destination}"><br>
        Start Point: <input type="text" name="startPoint" value="${ref.startPoint}"><br>
        Package price: <input type="number" name="packagePrice" value="${ref.packagePrice}"><br>
        Vehicle: <input type="text" name="vehicle" value="${ref.vehicle}"><br>
        Vehicle Number: <input type="text" name="vehicleNumber" value="${ref.vehicleNumber}"><br>
        Number of people: <input type="number" name="noOfPeople" value="${ref.noOfPeople}"><br>
        Start Date: <input type="date" name="startDate" value="${ref.startDate}"><br>
        End Date: <input type="date" name="endDate" value="${ref.endDate}"><br>
        <input type="submit" value="Update">
    </form>
    <a href="fetchAll">Go Back</a>
</div>

<footer>
    &copy; 2025 Tourism Management System | All Rights Reserved
</footer>

</body>
</html>
