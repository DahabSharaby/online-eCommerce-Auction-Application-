<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>allUsers </title>
    </head>
    <body>
    <h1>These are the users :</h1>
       
		<s:iterator value="usernames" status="statusVar">
	
		<tr>
		<s:property/>
		</tr>
	 
		</s:iterator>
	
    </body>
</html>