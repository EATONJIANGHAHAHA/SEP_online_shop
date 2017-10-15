<%@ include file = "header.jsp" %>

        <form action="register" method="post" class="form-horizontal" >
            <center><h3 class="page-header">Registration</h3></center>
            <div class="form-group">
                <label class="col-sm-2 control-label">Username:</label>

                <div class="col-sm-10">
                    <input style="width:50%" type="text" name="username" class="form-control" placeholder="Username...">
                </div>    
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password:</label>

                <div class="col-sm-10">
                    <input style="width:50%" type="password" name="password" class="form-control" placeholder="Password...">
                </div>    
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Repeated Password:</label>

                <div class="col-sm-10">
                    <input style="width:50%" type="password" name="repeatedPassword" class="form-control" placeholder="Repeated Password...">
                </div>    
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Email:</label>

                <div class="col-sm-10">
                    <input style="width:50%" type="text" name="email" class="form-control" placeholder="Email...">
                </div>    
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-2">
                    <input type="submit" label="Login In" class="btn btn-primary">
                </div>    
            </div>
        </form>


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
