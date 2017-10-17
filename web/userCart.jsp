<%-- 
    Document   : userCart
    Created on : Oct 17, 2017, 9:34:56 AM
    Author     : Edric
--%>

<%@ include file = "header.jsp" %>
    <body>
        <h1><s:property value="#session.itemowner[0].userName"/>'s cart</h1>
    <center>
        <% //itemTbl i = null;
            //i = session.getAttribute("itemlist");
            //if(i.size() == 0) {%>
            <!--<p>cart is empty</p>-->
        <%//}%>
        <%@ include file = "listItems.jsp" %>
        <s:url action="checkout" var="checkoutURL">
            <s:param name="selectedUserId" value="#session.user.userId"/>
            <s:param name="purchaseList" value="#session.itemlist"/>
        </s:url>
        <s:a href="%{checkoutURL}">Checkout items</s:a>
        
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">

  <!-- Identify your business so that you can collect the payments. -->
  <input type="hidden" name="business" value="herschelgomez@xyzzyu.com">

  <!-- Specify a Buy Now button. -->
  <input type="hidden" name="cmd" value="_xclick">

  <!-- Specify details about the item that buyers will purchase. -->
  <input type="hidden" name="item_name" value="Hot Sauce-12oz. Bottle">
  <input type="hidden" name="amount" value="5.95">
  <input type="hidden" name="currency_code" value="USD">

  <!-- Display the payment button. -->
  <input type="image" name="submit" border="0"
  src="https://www.paypalobjects.com/webstatic/en_US/i/btn/png/btn_buynow_107x26.png"
  alt="Buy Now">
  <img alt="" border="0" width="1" height="1"
  src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

</form>
    </center>
    </body>
<%@ include file = "footer.jsp" %>
