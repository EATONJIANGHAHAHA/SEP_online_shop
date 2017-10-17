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
        <%
            //javascript for the cart page
            //move this to a new file later
            UserTbl user = null;
            
            if (session.getAttribute("user")==null) { 
        %>
                <!--<meta http-equiv="refresh" content="0; URL=index.jsp">-->
        <%      
            } else {
                user=(UserTbl)session.getAttribute("user");
            }
        %>
    </head>
    <body>
        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <% if (user == null) { %>
                                <li><a href="register.jsp"><i class="fa fa-user"></i> Registration</a></li>
                                <li><a href="login.jsp"><i class="fa fa-user"></i> Login</a></li>
                                    <% } else { %>
                                <li><a href="my_account.jsp"><i class="fa fa-user"></i> My Account</a></li>
                                <li><a href="logout.jsp"><i class="fa fa-user"></i> Logout 
                                        <% out.print(user.getUserName()); %> </a></li>
                                <% }%>
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

                    <div class="col-sm-6">
                        <div class="shopping-item">
                            <% if (user != null){ %>
                                <s:url action="selectUserCart" var="usercartURL">
                                    <s:param name="selectedUserId" value="#session.user.userId"/>
                                </s:url>
                                <s:a href="%{usercartURL}">My Cart<i class="fa fa-shopping-cart"></i></s:a>
                            <% }%>
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
                            <li class="active"><a href="index.jsp">Home</a></li>
                            <!--<li><a href="shop.jsp">Shop page</a></li>-->
                            <!--<li><a href="single-product.html">Single product</a></li>-->
                            <!--<li><a href="cart.jsp">Cart</a></li>-->
                            <!--<li><a href="checkout.html">Checkout</a></li>-->
                            <!--<li><a href="#">Category</a></li>-->
                            <!--<li><a href="#">Others</a></li>-->
                            <% if (user != null) { %>
                            <li><a href="addItem.jsp">Add item</a></li>
                            <% }%>
                            <li>
                                <form action="search" method="post"> <!-- what does method="get" do? -->
                                <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
                                    <tr>
                                        <!-- keyword is a variable used by SearchAction specified by struts.xml -->
                                        <td><input type="text" name="keyword" placeholder="Search"></td>
                                        <td colspan="2" align="right"><input type="submit" label="Search" class="btn btn-primary" text="Search"></td>
                                    </tr>

                                </table>
                                </form>
                            </li>
                        </ul>
                    </div>  
                </div>
            </div>
        </div> <!-- End mainmenu area -->