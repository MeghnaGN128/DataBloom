<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>All Data</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        header {
            background-color: #004080;
            color: white;
            padding: 20px;
            text-align: center;
        }

        footer {
            background-color: #004080;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        h2, h4 {
            text-align: center;
        }

        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: white;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #0066cc;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .back-link {
            display: block;
            text-align: center;
            margin: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<header>
    <h1>Tourism Management Portal</h1>
</header>

<h2>Tourism Table</h2>
<h4>${message}</h4>

<table>
    <tr>
        <th>TourID</th>
        <th>Destination</th>
        <th>Start Point</th>
        <th>Package Price</th>
        <th>Vehicle</th>
        <th>Vehicle Number</th>
        <th>No Of People</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Action</th>
    </tr>

    <c:forEach var="item" items="${tourismDTOList}">
        <tr>
            <td>${item.tourID}</td>
            <td>${item.destination}</td>
            <td>${item.startPoint}</td>
            <td>${item.packagePrice}</td>
            <td>${item.vehicle}</td>
            <td>${item.vehicleNumber}</td>
            <td>${item.noOfPeople}</td>
            <td>${item.startDate}</td>
            <td>${item.endDate}</td>
            <td>
                <a href="getByID?id=${item.tourID}">View</a> /
                <a href="edit?id=${item.tourID}">Edit</a> /
                <a href="delete/${item.tourID}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td>${dto.tourID}</td>
        <td>${dto.destination}</td>
        <td>${dto.startPoint}</td>
        <td>${dto.packagePrice}</td>
        <td>${dto.vehicle}</td>
        <td>${dto.vehicleNumber}</td>
        <td>${dto.noOfPeople}</td>
        <td>${dto.startDate}</td>
        <td>${dto.endDate}</td>
        <td><a href="fetchAll">View All</a></td>
    </tr>
</table>

<a class="back-link" href="backToIndex">Go Back</a>

<footer>
    <p>&copy; 2025 Tourism Company. All rights reserved.</p>
</footer>

</body>
</html>
