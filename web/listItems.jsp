
        <center>
            
            <% if (session.getAttribute("itemlist") != null) { 
            %>
            
         <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container-fluid">
                
                <s:iterator value="#session.itemlist">
                    <div class="container" style="border:1px solid #cecece;">
                <div class="row" >
                    
                    <div class="col-md-3">     
                        <br>
                        <h1>
                                <s:url action="selectItem" var="testURL"> <!-- (for index format user login button)use a form instead, method="post" does not work-->
                                    <s:param name="selectedId" value="itemId" />
                                </s:url>
                                <s:a href="%{testURL}"><s:property value="itemName"/></s:a>
                            </h1>
                        <br>
                        <div class="single-shop-product">
                            
                            
                            
                                <div class="product-upper"> 
                                <s:a href="%{testURL}">
                                    <img src="img/harry_potter.jpg" class="img-thumbnail" alt="" style="float:left;border:1;"> <!-- replace with image path -->
                                </s:a>
                            </div>
                            
                                
                            
                            
                        </div>
                        
                    </div>
                        <div class="col-md-7" > 
                            <br>
                            <br>
                            <div class="product-carousel-price" >
                                <h3 class="text-left"><ins>$<s:property value="price"/></ins></h3>
                            </div> 
                            <div class="product-option-shop" >
                                <p class="text-left"><s:property value="itemDescription"/></p>
                                <br><br><br>
                                <p class="text-left">Stock: <s:property value="stock"/></p>
                                <p class="text-left">ID: <s:property value="itemId"/></p>
                                <p class="text-left"><s:a href="%{testURL}">Details</s:a></p>
                                <p class="text-left"><s:property value="itemImage"/></p>
                            </div>
                        </div>
                    
                </div>
                        
                    <br>
                    </div>
                    <br>
                    <br>
                    </s:iterator>
                <%      }
                        session.setAttribute("itemlist", null); 
                    
                %>
            </div>
            
        </center>
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