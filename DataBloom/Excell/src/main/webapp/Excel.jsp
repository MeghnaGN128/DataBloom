<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Excel Upload</title>
</head>
<body>
<h2>Upload Excel File</h2>

<form action="send" method="post" enctype="multipart/form-data">
    <input type="file" name="excelFile" accept=".xls,.xlsx" required />
    <br/><br/>
    <input type="submit" value="Upload and Read" />
</form>

<c:if test="${not empty message}">
    <p style="color: red;">${message}</p>
</c:if>

</body>
</html>
