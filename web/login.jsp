<%-- 
    Document   : login
    Created on : 29-Aug-2017, 13:35:46
    Author     : lzy
--%>
<%@page import="com.uts.sep.entity.UserTbl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEP-bay login</title>
        <link href="css/bootstrap.css" type="text/css" rel="stylesheet">

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
    </head>
    <body>
        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <!--<li><a href="my_account.jsp"><i class="fa fa-user"></i> My Account</a></li>-->
                                <!--                                <li><a href="register.jsp"><i class="fa fa-user"></i> Registration</a></li>
                                                                <li><a href="cart.jsp"><i class="fa fa-user"></i> My Cart</a></li>
                                                                <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                                                                <li><a href="login.jsp"><i class="fa fa-user"></i> Login</a></li>-->
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
                            <h1><a href="index.html">sep<span>BAY</span></a></h1>
                        </div>                       
                    </div>

                    <!-- search bar form, moved to search.jsp
                    <div class="col-md-1">
                        <div class="user-menu">
                            <form action="search" method="post">
                
                                <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
                                    <tr>
                                        <th align="right">Search: </th>
                                        <td><input type="text" name="keyword" placeholder="Keywords"></td>
                                        <td colspan="2" align="right"><input type="submit" label="Search" class="btn btn-primary"></td>
                                    </tr>
                                    
                                </table>
                            </form>
                        </div>
                    </div>
                    -->

                    <!--                    <div class="col-sm-6">
                                            <div class="shopping-item">
                                                <a href="cart.html">Cart - <span class="cart-amunt">$800</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                                            </div>
                                        </div>-->
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
        <%@ include file = "header.jsp" %>
        <div>
            <br><br>
            <center><h1>Login In</h1></center>
            <br><br>
            <form action="login" method="post">

                <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
                    <tr>
                        <th align="right">User Name: </th>
                        <td><input type="text"  name="username" placeholder="Username"></td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <th align="right">Password: </th>
                        <td><input type="password"  name="password" placeholder="Password"></td>
                    </tr>

                    <tr>
                        <th></th>
                        <td colspan="2" align="right"><input type="submit" label="Login In" class="btn btn-primary"></td>
                    </tr> 
                </table>
            </form>

        </div>

        <div class="promo-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo">
                            <i class="fa fa-refresh"></i>
                            <p>30 Days return</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo">
                            <i class="fa fa-truck"></i>
                            <p>Free shipping</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo">
                            <i class="fa fa-lock"></i>
                            <p>Secure payments</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo">
                            <i class="fa fa-gift"></i>
                            <p>New products</p>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End promo area -->
    </body>
</html>
