<%@ page isELIgnored="false" %>
<html>
<body>
<div align="center">
    <form action="product" method="post">
        <h2>Product Details</h2>
        <p>${message}</p>

        Product Name:
        <input type="text" name="productName" placeholder="Enter Product Name" value="${dto.productName}" required><br><br>

        Price:
        <input type="text" name="price" placeholder="Enter Price" value="${dto.price}" required><br><br>

        Description:
        <input type="text" name="description" placeholder="Enter Description" value="${dto.description}"><br><br>

        <input type="submit" value="Submit Product">
    </form>
</div>
</body>
</html>
