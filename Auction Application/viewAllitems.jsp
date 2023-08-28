<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sale items </title>
    </head>
    <body>
    <h1>These are the items for sale :</h1>
       
		<s:iterator value="items" status="statusVar">
		<s:form action="addBids" >
		<tr>
		<td><s:property/></td>
		<input type="hidden" id="itemname" name="itemname" value="sweet"/>
		<td><input id="bid" name="bid" label="Please enter bid:"/></td>	
		</tr>
		<s:submit value = "Make a bid"/>
        </s:form>
		
		</s:iterator>
	
    </body>
</html>