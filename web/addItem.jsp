<%-- 
    Document   : index
    Created on : 29-Aug-2017, 15:00:13
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
                <%@ include file = "header.jsp" %>

                <form action="addItem" method="post" enctype="multipart/form-data" id="additemfrm">
                    <center><h3 class="h3">Add Item</h3></center>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Item name:</label>

                        <div class="col-sm-10">
                            <input style="width:50%" type="text" name="itemname" class="form-control" placeholder="Item name...">
                        </div>    
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Price:</label>
                    </div>

                    <div class="col-sm-10">
                        <input style="width:50%" type="text" name="itemprice" class="form-control" placeholder="Item price...">
                    </div>    
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Description:</label>
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

                <!-- beginning of add item form -->
                <div class="col-md-1">
                    <div class="user-menu">
                        <form action="addItem" method="post">

                            <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
                                <tr>
                                    <th align="right">Add: </th>
                                    <!-- itemname is a variable used by AddAction specified by struts.xml -->
                                    <td><input type="text" name="keyword" placeholder="Item name"></td>
                                    <td colspan="2" align="right"><input type="submit" label="AddItem" class="btn btn-primary"></td>
                                </tr>

                                <div class="col-sm-10">

                                    <textarea style="width:50%" name="itemdescription" form="additemfrm" ></textarea>
                                </div>    
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Select image:</label>


                                    <div class="col-sm-10">
                                        <input style="width:50%;height:50px;" type="file" name="myFile" class="form-control" placeholder="Select image to upload...">
                                    </div>    
                                </div>
                                <input type="hidden" name="ownerid" value="<s:property value="#session.user.userId"/>" form="additemfrm">
                                <div class="form-group">
                                    <div class="col-sm-10 col-sm-offset-2">
                                        <input type="submit" label="Add Item" class="btn btn-primary">
                                    </div>    
                                </div>
                        </form>
                        <%@include file = "listItems.jsp" %>
                        <%@ include file = "footer.jsp" %>
                        </html>