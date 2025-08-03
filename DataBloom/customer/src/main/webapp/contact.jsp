<%@ page isELIgnored="false" %>
<html>
<body>
<div align="center">
    <form action="form" method="post">
        <h2>Customer Details</h2>
        <p>${message}</p>

        Name: <input type="text" name="name" placeholder="enter name" value="${contactDTO.name}" required><br><br>
        Email: <input type="text" name="email" placeholder="enter email" value="${contactDTO.email}" required><br><br>
        Phone Number: <input type="text" name="phoneNumber" placeholder="enter phone number" value="${contactDTO.phoneNumber}" required><br><br>
        Comments: <input type="text" name="comments" placeholder="enter comments" value="${contactDTO.comments}" required><br><br>

        <input type="submit" value="Click">
    </form>
</div>
</body>
</html>
