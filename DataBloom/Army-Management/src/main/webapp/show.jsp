<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }
        .container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        table {
            border-collapse: collapse;
            width: 70%;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        thead {
            background-color: #2a9df4;
            color: white;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f1f9ff;
        }

        /* Bottom navigation buttons */
        .nav-links {
            text-align: center;
            margin: 20px 0 80px; /* space for footer */
        }
        .nav-links a {
            display: inline-block;
            margin: 5px;
            padding: 10px 15px;
            background: linear-gradient(45deg, #87cefa, #4facfe);
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        .nav-links a:hover {
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
    </style>
</head>
<body>

<h2>Army Details - By ID</h2>

<div class="container">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Commander</th>
            <th>Base Location</th>
            <th>Established Date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${army.armyId}</td>
            <td>${army.armyName}</td>
            <td>${army.country}</td>
            <td>${army.commanderName}</td>
            <td>${army.baseLocation}</td>
            <td>${army.establishedDate}</td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Navigation buttons -->
<div class="nav-links">
    <a href="enter">Go to Army details</a>
    <a href="give">Go back home</a>
</div>

<!-- Footer -->
<footer>
    &copy; 2025 Army Management System | All Rights Reserved
</footer>

</body>
</html>
