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

                <div class="col-sm-10">
                    <input style="width:50%" type="text" name="itemprice" class="form-control" placeholder="Item price...">
                </div>    =]
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Description:</label>

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