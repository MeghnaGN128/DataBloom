<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Admin Dashboard - Kamadhenu Milk Products</title>

    <!-- Bootstrap CSS & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"/>

    <!-- External CSS -->
    <link href="CSS/styles.css" rel="stylesheet"/>
    <style>
        /* Page-specific sidebar styles */
        .sidebar.sidebar-yellow {
            background: #FFF9DB; /* soft yellow */
            border-right: 1px solid #F2D16D;
            min-height: 100vh;
            position: sticky;
            top: 0;
        }
        .sidebar.sidebar-yellow h5 {
            color: #5B4A00;
            letter-spacing: 0.3px;
        }
        .sidebar.sidebar-yellow .nav-link {
            color: #5B4A00;
            padding: 10px 16px;
            border-radius: 8px;
            margin: 0 10px 8px 10px;
            transition: background-color 0.2s ease, color 0.2s ease, transform 0.05s ease;
            font-weight: 500;
        }
        .sidebar.sidebar-yellow .nav-link:hover {
            background: #FFEAA7; /* hover yellow */
            color: #3F3200;
        }
        .sidebar.sidebar-yellow .nav-link.active,
        .sidebar.sidebar-yellow .nav-link:focus {
            background: #FFD866; /* active yellow */
            color: #2C2300;
            box-shadow: inset 2px 0 0 #C9A227;
        }
        .sidebar.sidebar-yellow .nav-link.text-danger {
            color: #B00020 !important;
        }
        .sidebar.sidebar-yellow .nav-link.text-danger:hover {
            background: #FFE5E7;
        }
        @media (max-width: 767.98px) {
            .sidebar.sidebar-yellow { position: static; min-height: auto; }
        }

        /* Dashboard metric cards */
        .metric-card {
            background: #ffffff;
            border: 1px solid #f2e6b3; /* subtle yellow border */
            border-radius: 16px;
            padding: 24px;
            display: flex;
            align-items: center;
            gap: 18px;
            box-shadow: 0 3px 14px rgba(0,0,0,0.06);
            transition: transform 0.08s ease, box-shadow 0.2s ease;
            min-height: 120px;
        }
        .metric-card:hover { transform: translateY(-2px); box-shadow: 0 6px 18px rgba(0,0,0,0.08); }
        .metric-icon {
            width: 64px; height: 64px; border-radius: 12px;
            display: grid; place-items: center;
            background: #FFF4BF; color: #5B4A00;
        }
        .metric-icon i { font-size: 1.75rem; }
        .metric-content .label { color: #6b5a00; font-weight: 600; font-size: 14px; letter-spacing: .3px; }
        .metric-content .value { font-size: 32px; font-weight: 700; color: #2C2300; line-height: 1; }
        .metric-products .metric-icon { background: #FFF4BF; }
        .metric-orders .metric-icon { background: #E7F0FF; color: #103F91; }
        .metric-customers .metric-icon { background: #EFFFF4; color: #0C6B32; }
        .metric-agents .metric-icon { background: #FFEFF4; color: #9A1C39; }

        /* Quick Actions */
        .quick-actions .action-card {
            background: #ffffff;
            border: 1px solid #f2e6b3;
            border-radius: 14px;
            padding: 16px 18px;
            display: flex;
            align-items: center;
            gap: 12px;
            height: 100%;
            transition: background 0.2s ease, box-shadow 0.2s ease, transform 0.06s ease;
        }
        .quick-actions .action-card:hover {
            background: #FFF9DB;
            box-shadow: 0 6px 18px rgba(0,0,0,0.06);
            transform: translateY(-1px);
        }
        .quick-actions .icon {
            width: 40px; height: 40px; border-radius: 10px;
            display: grid; place-items: center;
            background: #FFF4BF; color: #5B4A00;
        }
        .quick-actions .label { font-weight: 600; color: #3F3200; }
        .quick-actions a { text-decoration: none; color: inherit; }

        /* Overview panel */
        .panel-card {
            background: #ffffff;
            border: 1px solid #f2e6b3;
            border-radius: 14px;
            padding: 18px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.04);
        }
        .panel-card h6 { color: #5B4A00; font-weight: 700; margin-bottom: 12px; }
        .panel-list { list-style: none; padding-left: 0; margin: 0; }
        .panel-list li { display: flex; justify-content: space-between; align-items: center; padding: 8px 0; border-bottom: 1px dashed #f0e4a8; }
        .panel-list li:last-child { border-bottom: none; }
        .chip { padding: 2px 8px; border-radius: 999px; font-size: 12px; font-weight: 600; }
        .chip.info { background: #E7F0FF; color: #103F91; }
        .chip.success { background: #EFFFF4; color: #0C6B32; }
        .chip.warn { background: #FFF4BF; color: #5B4A00; }
    </style>
</head>
<body class="d-flex flex-column min-vh-100">


<!-- Navbar -->
<nav class="navbar navbar-expand-lg custom-navbar">
    <div class="container">
        <a class="navbar-brand fw-bold" href="index.jsp">
            <span class="logo-badge">
                <img src="images/logo.jpg" alt="Kamadhenu Logo" style="height:50px;"/>
            </span>
            Kamadhenu Milk
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="navbar-nav ms-auto align-items-center">
                <!-- Admin Profile Dropdown -->
                <div class="nav-item dropdown">
                    <a class="nav-link p-0 dropdown-toggle" href="#" id="adminDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="images/adminprofile.jpg" alt="Admin Profile"
                             class="rounded-circle border" style="height:40px;width:40px; object-fit:cover;">
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="adminDropdown">
                        <li class="dropdown-item text-center">
                            <img src="images/adminprofile.jpg" alt="Admin Profile"
                                 class="rounded-circle mb-2" style="height:60px;width:60px;">
                            <div class="fw-bold">
                                ${sessionScope.adminDTO != null ? sessionScope.adminDTO.name : 'Admin'}
                            </div>
                            <div class="small text-muted">
                                ${sessionScope.adminDTO != null ? sessionScope.adminDTO.email : 'admin@kamadhenu.com'}
                            </div>
                        </li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item text-danger" href="adminprofile">Profile</a></li>
                        <li><a class="dropdown-item text-danger" href="adminLogin">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>


<!-- Main Layout -->
<div class="container-fluid flex-grow-1">
    <div class="row w-100">
        <!-- Sidebar -->
        <nav class="col-md-2 sidebar sidebar-yellow d-flex flex-column h-100 p-0">
            <h5 class="fw-bold mb-4 ps-3 pt-3">Dashboard</h5>
            <div class="nav flex-column">
                <a class="nav-link" href="#">Products</a>
                <a class="nav-link" href="#">Orders</a>
                <a class="nav-link" href="#">Agents</a>
                <a class="nav-link" href="#">Customers</a>
                <a class="nav-link text-danger" href="logout">Logout</a>
            </div>
        </nav>

        <!-- Content Area -->
        <main class="col-md-10 ms-sm-auto px-4 py-3">
            <div class="mb-4">
                <h3 class="mb-1">Welcome, ${sessionScope.adminDTO != null ? sessionScope.adminDTO.name : 'Admin'}</h3>
                <div class="text-muted">Email: ${sessionScope.adminDTO != null ? sessionScope.adminDTO.email : 'admin@kamadhenu.com'}</div>
            </div>

            <!-- Dashboard Summary Cards -->
            <div class="row g-3">
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="metric-card metric-products">
                        <div class="metric-icon">
                            <i class="bi bi-basket2-fill fs-4"></i>
                        </div>
                        <div class="metric-content">
                            <div class="label">Products</div>
                            <div class="value"><c:out value="${productsCount}" default="0"/></div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="metric-card metric-orders">
                        <div class="metric-icon">
                            <i class="bi bi-receipt-cutoff fs-4"></i>
                        </div>
                        <div class="metric-content">
                            <div class="label">Orders</div>
                            <div class="value">
                                <c:out value="${ordersCount}" default="0"/></div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="metric-card metric-customers">
                        <div class="metric-icon">
                            <i class="bi bi-people-fill fs-4"></i>
                        </div>
                        <div class="metric-content">
                            <div class="label">Customers</div>
                            <div class="value"><c:out value="${customersCount}" default="0"/></div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="metric-card metric-agents">
                        <div class="metric-icon">
                            <i class="bi bi-person-badge-fill fs-4"></i>
                        </div>
                        <div class="metric-content">
                            <div class="label">Agents</div>
                            <div class="value"><c:out value="${agentsCount}" default="0"/></div>
                        </div>
                    </div>
                </div>
            </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white mt-auto">
    <div class="container text-center text-md-start py-3">
        <div class="row">
            <div class="col-md-4 mb-3">
                <h5 class="fw-bold mb-2">Kamadhenu Milk Products</h5>
                <p>Bringing you fresh milk, curd, ghee, paneer and more from trusted farmers.</p>
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

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
