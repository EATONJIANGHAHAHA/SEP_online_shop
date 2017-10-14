<%-- 
    Document   : index
    Created on : 29-Aug-2017, 15:00:13
    Author     : lzy
--%>
<%@page import="com.uts.sep.dao.ItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.uts.sep.action.AddToCartAction"%>
<%@page import="com.uts.sep.dao.ShoppingCartDAO"%>
<%@page import="com.uts.sep.entity.ItemTbl"%>
<%@page import="com.uts.sep.entity.UserTbl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SEP</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <%! UserTbl user; %>
        <%! ItemDAO itemDao = new ItemDAO();%>
        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <%
                                    if (session.getAttribute("user") != null) {
                                %>
                                <li><a href="my_account.jsp"><i class="fa fa-user"></i> My Account</a></li>
                                    <%
                                        }
                                    %>
                                <li><a href="register.jsp"><i class="fa fa-user"></i> Registration</a></li>
                                <li><a href="cart.jsp"><i class="fa fa-user"></i> My Cart</a></li>
                                <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                                    <% if (session.getAttribute("user") == null) { %>
                                <li><a href="login.jsp"><i class="fa fa-user"></i> Login</a></li>
                                    <% } else {
                                    %>
                                <li><a href="logout.jsp"><i class="fa fa-user"></i> Logout
                                        <%  UserTbl user = (UserTbl) session.getAttribute("user");
                                            out.print(user.getUserName()); %></a></li>
                                        <% } %>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="header-right">
                            <ul class="list-unstyled list-inline">
                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">AUD</a></li>
                                        <li><a href="#">USD</a></li>
                                        <li><a href="#">GBP</a></li>
                                    </ul>
                                </li>

                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">English</a></li>
                                        <li><a href="#">French</a></li>
                                        <li><a href="#">German</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End header area -->

        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                            <h1><a href="index.jsp">sep<span>BAY</span></a></h1>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End site branding area -->


        <div class="mainmenu-area">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.html">Home</a></li>
                            <li><a href="shop.jsp">Shop page</a></li>
                            <li><a href="details.jsp">Single product</a></li>
                                <%
                                    if (null != session.getAttribute("user")) {
                                %>
                            <li><a href="cart.jsp">Cart</a></li>
                                <%
                                    }
                                %> 
                            <li><a href="#">Checkout</a></li>
                            <li><a href="#">Category</a></li>
                            <li><a href="search.jsp">Search</a></li>

                            <%
                                if (null == session.getAttribute("user")) {

                                } else if (null != session.getAttribute("user")) {
                                    UserTbl user = (UserTbl) session.getAttribute("user");
                                    if (user.getUserType() == 1) {
                            %>
                            <li><a href="addItem.jsp">Add item</a></li>
                                <%
                                        }
                                    }
                                %>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </div> 
                </div>
            </div>
        </div> <!-- End mainmenu area -->

        <!--        <div class="single-product-area">-->
        <%@ include file = "header.jsp" %>
    <center>
        <h1>cart of <s:property value="#session.user.userName"/></h1>
    </center>

    <div class="promo-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">                     
                    <div class="single-shop-product">
                        <%
                            if (null != itemDao.getItems()) {
                                for (ItemTbl usingItem : itemDao.getItems()) {
                        %>
                        <div class="product-upper"> 
                            <img src="<%=usingItem.getImage()%>" alt="">
                        </div>
                        <h2><a href=""><%=usingItem.getItemName()%></a></h2>
                        <div class="product-carousel-price">
                            <ins>$<%=usingItem.getPrice()%></ins> <del>$299.00</del>
                        </div>
                        <input type="button"
                               id="<%=usingItem.getItemId()%>"
                               onclick="removeFromCartFunction(this.id)"
                               class="add_to_cart_button"
                               value="Remove">
                        <script>
                            function removeFromCartFunction(itemNumber) {
                                var usingItemId = document.getElementById(itemNumber).id;
                                $(document).ready(function () {
                                    $.ajax({
                                        type: "post",
                                        url: "remove_from_cart"
                                    })
                                })
                            }
                        </script>
                        <%
                                }
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>