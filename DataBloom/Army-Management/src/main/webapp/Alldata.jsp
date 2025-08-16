<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html xmlns:c="">
<head>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background-color: #eef2f5; /* light gray-blue */
            color: #333;
            margin: 0;
            padding: 0; /* moved padding so header touches top */
        }

        /* HEADER / NAVBAR */
        nav {
            background: linear-gradient(90deg, #87cefa, #4facfe);
            padding: 14px 25px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }
        nav h1 {
            color: white;
            font-size: 20px;
            margin: 0;
        }
        nav a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            margin-left: 15px;
        }
        nav a:hover {
            text-decoration: underline;
        }

        h2 {
            color: #4facfe;
            margin: 20px 0;
        }

        table {
            border-collapse: collapse;
            background: white;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px 12px;
            text-align: center;
        }
        th {
            background-color: #87cefa;
            color: white;
        }
        tr:hover {
            background-color: #f1f7fc;
        }

        /* Action links as buttons */
        td a {
            text-decoration: none;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 4px;
            color: white;
            margin: 0 2px;
            display: inline-block;
        }
        td a[href^="show"] { background-color: #4facfe; }
        td a[href^="show"]:hover { background-color: #2196f3; }
        td a[href^="edit"] { background-color: #ff9800; }
        td a[href^="edit"]:hover { background-color: #e68900; }
        td a[href^="delete"] { background-color: #f44336; }
        td a[href^="delete"]:hover { background-color: #d32f2f; }

        /* Bottom links */
        a[href="enter"], a[href="give"] {
            display: inline-block;
            margin: 10px 5px;
            padding: 10px 15px;
            background: linear-gradient(45deg, #87cefa, #4facfe);
            color: white !important;
            border-radius: 6px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        a[href="enter"]:hover, a[href="give"]:hover {
            transform: translateY(-2px);
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

        /* Space above footer */
        .page-wrapper {
            padding-bottom: 60px;
        }
    </style>
</head>
<body>

<!-- HEADER -->
<nav>
    <h1>Army Management System</h1>
    <div>
        <a href="give">Home</a>
        <a href="enter">Add Details</a>
    </div>
</nav>

<div class="page-wrapper" align="center">
    <h2>Army Data Table</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Commander</th>
            <th>Base Location</th>
            <th>Established Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="army" items="${armies}">
            <tr>
                <td>${army.armyId}</td>
                <td>${army.armyName}</td>
                <td>${army.country}</td>
                <td>${army.commanderName}</td>
                <td>${army.baseLocation}</td>
                <td>${army.establishedDate}</td>
                <td>
                    <a href="show?id=${army.armyId}">Show</a>
                    <a href="edit?id=${army.armyId}">Edit</a>
                    <a href="delete?id=${army.armyId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="enter">Go to Army details</a>
    <a href="give">Go back home</a>
</div>

<!-- Footer -->
<footer>
    &copy; 2025 Army Management System | All Rights Reserved
</footer>

</body>
</html>
