<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Single Data</title>
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

        /* DATA BOX */
        .data-container {
            max-width: 600px;
            margin: 60px auto;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            line-height: 1.8;
            font-size: 16px;
        }

        .data-container span.label {
            font-weight: bold;
            color: #004080;
        }

        .data-container a {
            display: inline-block;
            margin-top: 20px;
            color: #004080;
            text-decoration: none;
            font-weight: bold;
        }

        .data-container a:hover {
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
    Tourism Management System - Tour Details
</header>

<div class="data-container" align="center">
    <div><span class="label">Tour ID:</span> ${dto.tourID}</div>
    <div><span class="label">Destination:</span> ${dto.destination}</div>
    <div><span class="label">Start Point:</span> ${dto.startPoint}</div>
    <div><span class="label">Package Price:</span> ${dto.packagePrice}</div>
    <div><span class="label">Vehicle:</span> ${dto.vehicle}</div>
    <div><span class="label">Vehicle Number:</span> ${dto.vehicleNumber}</div>
    <div><span class="label">Number of People:</span> ${dto.noOfPeople}</div>
    <div><span class="label">Start Date:</span> ${dto.startDate}</div>
    <div><span class="label">End Date:</span> ${dto.endDate}</div>
    <a href="fetchAll">View All</a>
</div>

<footer>
    &copy; 2025 Tourism Management System | All Rights Reserved
</footer>

</body>
</html>
