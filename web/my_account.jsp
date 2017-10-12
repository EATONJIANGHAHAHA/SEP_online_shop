<%@ include file = "header.jsp" %>

        <div>
            <form action="modify_user" method="post">
                <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
                    <center><h3 class="page-header">Change password</h3></center>
                    <tr>
                        <th align="right">Old Password: </th>
                        <td><input type="password" name="checkPassword" placeholder="Old password"/></td>
                    </tr>
                    <tr>
                        <th align="right">New name: </th>
                        <td><s:property value="#user.userName"/></td>
                    </tr>
                    <tr>
                        <th align="right">New Password: </th>
                        <td><input type="text" name="newPassword" placeholder="New password"/><td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" class="btn btn-primary"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            <center><h3 class="page-header">Email</h3></center>
            <center><p>change your email</p></center>
        </div>
        <div>
            <center><h3 class="page-header">PayPal account details</h3></center>
            <center><p>transactions will be paid to this account</p></center>
        </div>
        <div>
            <center><h3 class="page-header">Your items for sale</h3></center>
            <center><p>Make changes to any item you are selling</p></center>
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