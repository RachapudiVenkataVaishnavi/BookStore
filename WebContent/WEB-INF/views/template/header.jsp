<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Book Store</title>

    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- MaCarouselin CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
  
   <script>
   function registerValidation()
   {
	   
	   var name=document.getElementById("name").value;
	   var email=document.getElementById("name").value;
	   var phone=document.getElementById("phone").value;
	   var username=document.getElementById("username").value;
	   var password=document.getElementById("password").value;
	   var billingStreet=document.getElementById("billingStreet").value;
	   var billingApartmentNumber=document.getElementById("billingApartmentNumber").value;
	   var billingCity=document.getElementById("billingCity").value;
	   var billingState=document.getElementById("billingState").value;
	   var billingCountry=document.getElementById("billingCountry").value;
	   var billingZip=document.getElementById("billingZip").value;
	   var shippingStreet=document.getElementById("shippingStreet").value;
	   var shippingApartmentNumber=document.getElementById("shippingApartmentNumber").value;
	   var shippingCity=document.getElementById("shippingCity").value;
	   var shippingCountry=document.getElementById("shippingCountry").value;
	   var shippingZip=document.getElementById("shippingZip").value;
	 
	   if(name=="" || name==null)
	    {
	        alert("Please Enter Name");
	        document.getElementById("name").style.borderColor="red";
	        
	        return false;
	    }else if(email=="" || email==null)
	     {
	         alert("Please Enter Email");
	         document.getElementById("email").style.borderColor="red";
	         return false;
	     }else if(phone=="" || phone==null)
	     {
	         alert("Please Enter phone");
	         document.getElementById("phone").style.borderColor="red";
	         return false;
	     }else if(username=="" || username==null)
	     {
	         alert("Please Enter username");
	         document.getElementById("username").style.borderColor="red";
	         return false;
	     }else if(password=="" || password==null)
	     {
	         alert("Please Enter password");
	         document.getElementById("password").style.borderColor="red";
	         return false;
	     }else if(billingStreet=="" || billingStreet==null)
	     {
	         alert("Please Enter billingStreet");
	         document.getElementById("billingStreet").style.borderColor="red";
	         return false;
	     }else if(billingApartmentNumber=="" || billingApartmentNumber==null)
	     {
	         alert("Please Enter billingApartmentNumber");
	         document.getElementById("billingApartmentNumber").style.borderColor="red";
	         return false;
	     }else if(billingCity=="" || billingCity==null)
	     {
	         alert("Please Enter billingCity");
	         document.getElementById("billingCity").style.borderColor="red";
	         return false;
	     }else if(billingState=="" || billingState==null)
	     {
	         alert("Please Enter billingState");
	         document.getElementById("billingState").style.borderColor="red";
	         return false;
	     }else if(billingCountry=="" || billingCountry==null)
	     {
	         alert("Please Enter billingCountry");
	         document.getElementById("billingCountry").style.borderColor="red";
	         return false;
	     }else if(billingZip=="" || billingZip==null)
	     {
	         alert("Please Enter billingZip");
	         document.getElementById("billingZip").style.borderColor="red";
	         return false;
	     }else if(shippingStreet=="" || shippingStreet==null)
	     {
	         alert("Please Enter shippingStreet");
	         document.getElementById("shippingStreet").style.borderColor="red";
	         return false;
	     }else if(shippingApartmentNumber=="" || shippingApartmentNumber==null)
	     {
	         alert("Please Enter shippingApartmentNumber");
	         document.getElementById("shippingApartmentNumber").style.borderColor="red";
	         return false;
	     }else if(shippingCity=="" || shippingCity==null)
	     {
	         alert("Please Enter shippingCity");
	         document.getElementById("shippingCity").style.borderColor="red";
	         return false;
	     }else if(shippingCountry=="" || shippingCountry==null)
	     {
	         alert("Please Enter shippingCountry");
	         document.getElementById("shippingCountry").style.borderColor="red";
	         return false;
	     }else if(shippingZip=="" || shippingZip==null)
	     {
	         alert("Please Enter shippingZip");
	         document.getElementById("shippingZip").style.borderColor="red";
	         return false;
	     }
	   
	   
	   
	   
   }
   </script>

</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Book Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/" />">Home</a></li>
                         <c:if test="${sessionScope.user.username != 'admin'}">
                        <li><a href="<c:url value="/product/productList/all" />">Products</a></li>
                        </c:if>
                        <li><a href="<c:url value="/about" />">About Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${sessionScope.user.username != null}">
                            <li><a>Welcome: ${sessionScope.user.username}</a></li>
                            <li><a href="<c:url value="/logout" />">Logout</a></li>

                            <c:if test="${sessionScope.user.username == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </c:if>

                            <c:if test="${sessionScope.user.username != 'admin'}">
                                <li><a href="<c:url value="/customer/cart" />">Cart</a></li>
                            </c:if>

                           

                        </c:if>

                       <c:if test="${sessionScope.user.username == null}">
                            <li><a href="<c:url value="/login" />">Login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a></li>
                        </c:if> 
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>