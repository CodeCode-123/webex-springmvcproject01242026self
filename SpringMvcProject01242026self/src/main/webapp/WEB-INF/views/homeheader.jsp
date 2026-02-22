<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <head>
  <title>Project</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.css">
  <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div class="container-fluid top-header">
  <nav class="navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-3 col-4">
          <a class="navbar-brand" href="#">
            <img src="${contextPath}/resources/images/logo.png">
          </a>
        </div>
        <div class="col-lg-6 col-md-6 col-2">
          <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Category</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Menu List</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Our Services</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Testimonial</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Contact Us</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-3 col-6 social-media">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
          <a href="#">
            <i class="fa fa-search"></i>
          </a>
          <a href="#">
            <i class="fa fa-cart-plus"></i>
          </a>
        </div>
      </div>
    </div>
  </nav>
  </div>