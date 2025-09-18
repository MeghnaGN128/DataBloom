<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Admin Profile - Kamadhenu Milk Products</title>

    <!-- Bootstrap CSS & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"/>

    <!-- External CSS -->
    <link href="CSS/adminprofile.css" rel="stylesheet"/>
<style>
    /* Navbar Light Yellow */
    .custom-navbar {
    background-color: #fff9c4 !important;  /* Light Yellow */
    padding: 0.8rem 1rem;
    font-size: 1rem;
    border-bottom: 1px solid #e0e0e0;
    }

    .custom-navbar .nav-link,
    .custom-navbar .navbar-brand {
    color: #333 !important;   /* Dark text */
    font-weight: 500;
    }

    .custom-navbar .nav-link:hover {
    color: #d84315 !important;  /* Orange hover */
    }
</style>
</head>
<body>

<!-- Navbar -->
    <nav class="navbar navbar-expand-lg custom-navbar">
    <div class="container">
        <!-- Brand -->
        <a class="navbar-brand fw-bold d-flex align-items-center" href="index.jsp">
            <span class="logo-badge me-2">
                <img src="images/logo.jpg" alt="Kamadhenu Logo" style="height:50px;"/>
            </span>
            Kamadhenu Milk
        </a>

        <!-- Toggler -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="index.jsp">Home</a>
            </div>
        </div>
    </div>
</nav>
<c:if test="${not empty message}">
    <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<!-- Profile Card -->
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow admin-profile-card">
                <div class="card-body text-center">
                    <img src="images/adminprofile.jpg" alt="Admin Profile" class="rounded-circle mb-3 admin-profile-img">
                    <div class="fw-bold">
                        ${sessionScope.adminDTO != null ? sessionScope.adminDTO.name : 'Admin'}
                    </div>
                    <div class="small text-muted">
                        ${sessionScope.adminDTO != null ? sessionScope.adminDTO.email : 'admin@kamadhenu.com'}
                    </div>
                    <div class="small text-muted">
                        ${sessionScope.adminDTO != null ? sessionScope.adminDTO.mobileNumber : '+91 98765 43210'}
                    </div>
                    <hr>
                    <!-- Logout & Update Buttons -->
                    <form action="adminprofile" method="post" class="mb-3">
                        <input type="hidden" name="action" value="logout"/>
                        <button type="button" class="btn btn-warning" data-bs-toggle="collapse" data-bs-target="#updateProfileForm">
                            Update Profile
                        </button>
                    </form>
                    <form action="logout" method="get" class="mb-3">
                        <button type="submit" class="btn btn-danger me-2">Logout</button>
                    </form>


                    <!-- Update Profile Form (Collapsible) -->
                    <div class="collapse mt-3" id="updateProfileForm">
                        <form action="updateAdminProfile" method="post">
                            <div class="mb-3 text-start">
                                <label class="form-label">Name</label>
                                <input type="text" name="name" class="form-control"
                                       value="${sessionScope.adminDTO != null ? sessionScope.adminDTO.name : ''}" required/>
                            </div>
                            <div class="mb-3 text-start">
                                <label class="form-label">Email</label>
                                <input type="email" name="email" class="form-control"
                                       value="${sessionScope.adminDTO != null ? sessionScope.adminDTO.email : ''}" readonly/>
                            </div>
                            <div class="mb-3 text-start">
                                <label class="form-label">Mobile Number</label>
                                <input type="text" name="mobileNumber" class="form-control"
                                       value="${sessionScope.adminDTO != null ? sessionScope.adminDTO.mobileNumber : ''}" required/>
                            </div>
                            <div class="mb-3 text-start">
                                <label class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" placeholder="Enter new password"/>
                            </div>
                            <button type="submit" class="btn btn-success">Save Changes</button>
                        </form>
                    </div>

                    <!-- Logout Button -->
                    <form action="adminprofile" method="post">
                        <input type="hidden" name="action" value="logout"/>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white pt-4 pb-3 mt-auto">
    <div class="container text-center text-md-start">
        <div class="row">
            <div class="col-md-4 mb-3">
                <h5 class="fw-bold mb-2">Kamadhenu Milk Products</h5>
                <p>Bringing you fresh milk, curd, ghee, paneer and more from trusted farmers. Natural goodness with every drop.</p>
            </div>
            <div class="col-md-2 mb-3">
                <h6 class="fw-bold mb-2">Quick Links</h6>
                <ul class="list-unstyled">
                    <li><a href="index.jsp" class="text-white text-decoration-none">Home</a></li>
                    <li><a href="register.jsp" class="text-white text-decoration-none">Register</a></li>
                    <li><a href="adminLogin.jsp" class="text-white text-decoration-none">Admin Login</a></li>
                    <li><a href="customerLogin.jsp" class="text-white text-decoration-none">Customer Login</a></li>
                </ul>
            </div>
            <div class="col-md-3 mb-3">
                <h6 class="fw-bold mb-2">Contact</h6>
                <p><i class="bi bi-geo-alt-fill me-2"></i> Bengaluru, Karnataka</p>
                <p><i class="bi bi-envelope-fill me-2"></i> support@kamadhenu.com</p>
                <p><i class="bi bi-telephone-fill me-2"></i> +91 98765 43210</p>
            </div>
            <div class="col-md-3 mb-3">
                <h6 class="fw-bold mb-2">Follow Us</h6>
                <a href="#" class="text-white fs-5 me-2"><i class="bi bi-facebook"></i></a>
                <a href="#" class="text-white fs-5 me-2"><i class="bi bi-twitter"></i></a>
                <a href="#" class="text-white fs-5 me-2"><i class="bi bi-instagram"></i></a>
                <a href="#" class="text-white fs-5"><i class="bi bi-linkedin"></i></a>
            </div>
        </div>
        <div class="text-center pt-2 border-top border-secondary">
            <p class="mb-0">&copy; 2025 Kamadhenu Milk Products. All Rights Reserved.</p>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
