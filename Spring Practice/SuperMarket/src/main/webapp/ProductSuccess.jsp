<%@ page isELIgnored="false" %>
<html>
<body>
<div align="center">
    <h2>Product Submitted Successfully</h2>
    <a href="Product.jsp">Submit Another Product</a>

    <p>${productDTO.productName}</p>
    <p>${productDTO.price}</p>
    <p>${productDTO.description}</p>
</div>
</body>
</html>
