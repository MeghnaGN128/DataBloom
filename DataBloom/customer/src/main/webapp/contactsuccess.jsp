<%@ page isELIgnored="false" %>
<html>
<body>
<div align="center">
    <h2>Details Successfully Submitted</h2>
    <a href="contact.jsp">Submit Another</a>
    <p>${contactDTO.name}</p>
    <p>${contactDTO.email}</p>
    <p>${contactDTO.phoneNumber}</p>
    <p>${contactDTO.comments}</p>
</div>
</body>
</html>
