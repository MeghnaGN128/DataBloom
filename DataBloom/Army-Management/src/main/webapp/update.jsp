<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Army Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f5; /* light gray-blue */
            margin: 0;
            color: #333;
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

        /* FORM CONTAINER */
        .form-container {
            max-width: 500px;
            margin: 50px auto 80px; /* bottom space for footer */
            background: white;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #4facfe;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        input[readonly] {
            background-color: #f5f5f5;
            cursor: not-allowed;
        }

        /* BUTTONS */
        .btn-primary {
            background: linear-gradient(45deg, #87cefa, #4facfe);
            color: white;
            border: none;
            font-weight: bold;
            padding: 10px;
            width: 100%;
            border-radius: 6px;
            cursor: pointer;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
            margin-bottom: 10px;
        }
        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0px 6px 12px rgba(0,0,0,0.18);
        }

        .btn-link {
            display: block;
            text-align: center;
            padding: 10px;
            background: linear-gradient(45deg, #87cefa, #4facfe);
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.12);
        }
        .btn-link:hover {
            transform: translateY(-2px);
            box-shadow: 0px 6px 12px rgba(0,0,0,0.18);
        }

        /* FOOTER */
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

<!-- HEADER -->
<nav>
    <h1>Army Management System</h1>
    <div>
        <a href="give">Home</a>
        <a href="enter">Add Details</a>
    </div>
</nav>

<!-- FORM -->
<div class="form-container">
    <h2>Update Army Details</h2>
    <form action="update" method="post">
        <label>Id:</label>
        <input type="number" name="armyId" value="${ref.armyId}" readonly>

        <label>Name:</label>
        <input type="text" name="armyName" value="${ref.armyName}" placeholder="Enter the Name">

        <label>Country:</label>
        <input type="text" name="country" value="${ref.country}" placeholder="Enter the country">

        <label>Commander Name:</label>
        <input type="text" name="commanderName" value="${ref.commanderName}" placeholder="Enter the commander name">

        <label>Base Location:</label>
        <input type="text" name="baseLocation" value="${ref.baseLocation}" placeholder="Enter the base location">

        <label>Established Date:</label>
        <input type="date" name="establishedDate" value="${ref.establishedDate}">

        <input type="submit" value="Save" class="btn-primary">

        <a href="give" class="btn-link">Go back home</a>
    </form>
</div>

<!-- FOOTER -->
<footer>
    &copy; 2025 Army Management System | All Rights Reserved
</footer>

</body>
</html>
