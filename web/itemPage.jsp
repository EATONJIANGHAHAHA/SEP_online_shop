<%@ include file = "header.jsp" %>
<center>
    <!-- access to user code
    <p>User with ID:<s:property value="#session.user.userId"/> is logged in</p>
    <p>Owner of the item:</p>
    <s:property value="#session.itemowner[0].userId"/><br>
    <s:property value="#session.itemowner[0].userName"/><br>
    -->
    <div class="container-fluid">
        <div class="container" style="border:1px solid #cecece;">
            <div class="row" >
                <div class="col-md-3">     
                    <br>


                    <h2>Seller:</h2>
                    <h2>
                        <s:url action="selectUser" var="userpageURL">
                            <s:param name="selectedUserId" value="#session.itemowner[0].userId"/>
                        </s:url>

                        <s:a href="%{userpageURL}"><s:property value="#session.itemowner[0].userName"/><br></s:a>
                        </h2>
                        <br>
                        <div class="single-shop-product">

                            <div class="product-upper"> 

                            <s:a href="%{userpageURL}">
                                <img src="img/user.png" class="img-thumbnail" alt="" style="border:1"> <!-- replace src with image path -->
                            </s:a>
                        </div>

                        <% if(user != null){ %> 
                        <s:url action="selectUserCart" var="usercartURL">
                            <s:param name="selectedUserId" value="#session.user.userId"/>
                            <s:param name="selectedItemId" value="#session.itemlist[0].itemId"/>
                        </s:url>
                        <s:a href="%{usercartURL}">
                            <button type="button" class="btn btn-primary">Add to Cart</button>
                        </s:a>

                        <% } else {%>

                        <a href="login.jsp">
                            <button type="button" class="btn btn-primary">You must log in to purchase</button>
                        </a>
                        <% } %>

                    </div>


                </div>
            </div>
            <div class="col-md-9">
                <%@ include file = "listItems.jsp" %>
            </div> 


        </div>

        <br>
    </div>
</div>

</center>
<%@ include file = "footer.jsp" %>