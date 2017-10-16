
<% if (session.getAttribute("itemlist") != null) {
%>    
<div class="single-product-area">
    <div class="container-fluid">  
        <div class="row">
            <s:iterator value="#session.itemlist">
                <div class="col-sm-6 col-md-3 item">
                    <div class="thumbnail">
                        <s:a href="%{testURL}">
                            <img src="img/<s:property value='itemImage' />" class="img-responsive list-group-image" alt="image" width="150" height="150"/> 
                        </s:a>
                        <div class="caption">
                            <h4 class="group list-group-item-heading">
                                <s:url action="selectItem" var="testURL"> <!-- (for index format user login button)use a form instead, method="post" does not work-->
                                    <s:param name="selectedId" value="itemId" />
                                </s:url>
                                <s:a href="%{testURL}"><s:property value="itemName"/></s:a>
                            </h4>
                            <p class="group list-group-item-heading"><s:property value="itemDescription"/></p>
                            <br>
                            <div class="row flex flex-row align-center">
                                <div class="col-xs-4">
                                    <p class="lead"><ins>$<s:property value="price"/></ins></p>
                                </div>
                                <div class="col-xs-8 flex flex-row align-center justify-right">
                                    <div class="number-in-stock" >
                                        <s:property value="stock"/> in stock
                                    </div>
                                    <button class="btn btn-success" onclick="" role="button">Add to cart</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </div>
    </div>

    <%  }
        session.setAttribute("itemlist", null);

    %>
    </div>

<!-- Beginning of OLD search results area of the web page -->
<div>
    <center>
        <% if (session.getAttribute("itemlist") != null) {
        %>
        <h1>List of all items</h1>
        <table>
            <!-- Row to format the column headings -->
            <tr>
                <td>ID of the product</td>
                <td>Name of the product</td>
                <td>Price of the product</td>
                <td># In Stock</td>
                <td>Product description</td>
                <td>Link to the product</td>
            </tr>
            <!-- Begin printing all the search results -->
            <!-- iterator loops through each item in the itemlist -->
            <!-- itemlist is obtained from ItemDAO class and accessed through the struts session object -->
            <s:iterator value="#session.itemlist">
                <tr>
                    <td><s:property value="itemId"/></td>
                <td><s:property value="itemName"/></td>
                <td>$<s:property value="price"/></td>
                <td><s:property value="stock"/></td>
                <td><s:property value="itemDescription"/></td>
                <!--<td><s:property value="itemImage"/><td>-->
                <td>
                <s:url action="selectItem" var="testURL"> <!-- (for index format user login button)use a form instead, method="post" does not work-->
                    <s:param name="selectedId" value="itemId" />
                </s:url>
                <s:a href="%{testURL}">Link</s:a>

                </td>
                </tr>
            </s:iterator>
            <!-- End of loop -->
            <% //session.setAttribute("itemlist", null); %>
        </table>
        <%}%>
    </center>
</div>
<!-- End of OLD the search results area of the web page -->