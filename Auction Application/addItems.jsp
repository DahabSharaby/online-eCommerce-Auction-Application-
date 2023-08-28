<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Items Page </title>
    </head>
    <body>
    <h1>Please enter the details:</h1>
        <s:form action="addItems" >
		
			 <s:textfield name="itemname" label="Please enter the item name:" />
			  <s:textfield name="price" label="Please enter the price:" />
            <s:submit />
        </s:form>
		
	
		
    </body>
</html>