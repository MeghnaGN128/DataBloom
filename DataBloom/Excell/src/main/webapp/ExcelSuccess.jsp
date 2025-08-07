<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Excel Upload Success</title>
    <meta charset="UTF-8" />

</head>

<body>

<!-- Success Message -->
<div class="container my-4">
    <h3 class="text-success text-center">File Uploaded Successfully: <strong>${file}</strong></h3>

    <h4 class="mt-4">Excel Content:</h4>

    <c:if test="${not empty excelData}">
        <div class="table-responsive">
            <table class="table table-bordered table-hover mt-3">
                <c:forEach var="row" items="${excelData}" varStatus="rowStatus">
                    <tr>
                        <c:forEach var="cell" items="${row}">
                            <c:choose>
                                <c:when test="${rowStatus.first}">
                                    <th>${cell}</th>
                                </c:when>
                                <c:otherwise>
                                    <td>${cell}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>

    <c:if test="${empty excelData}">
        <p>No data found in the uploaded Excel file.</p>
    </c:if>

    <a class="btn btn-success mt-4" href="Excel.jsp">Upload Another File</a>
</div>

</body>
</html>
