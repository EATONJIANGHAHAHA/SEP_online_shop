<%@ include file = "header.jsp" %>

<div class="bg-img">
<!--               <img src="img/slide-2.jpg" style="width:100% ; height:80%;" >-->
    <form action="search" method="post" class="search-form">  <!--what does method="get" do?--> 
        <table align ="center" style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
<!--                 keyword is a variable used by SearchAction specified by struts.xml -->
                <td><input type="text" name="keyword" placeholder="Search"></td>
                <td colspan="2" align="right"><input type="submit" label="Search" class="btn btn-primary" text="Search"></td>
            </tr>
        </table>
    </form>
</div>



<%@ include file = "footer.jsp" %> <!-- End promo area -->
