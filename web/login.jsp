<%-- 
    Document   : login
    Created on : 29-Aug-2017, 13:35:46
    Author     : lzy
--%>

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
