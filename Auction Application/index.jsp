<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page </title>
    </head>
    <body>
    <h1>Please enter your details:</h1>
        <s:form action="register" >
			 <s:textfield name="username" label="Please enter your username:" />
			  <s:textfield name="password" label="Please enter your password:" />
            <s:submit />
        </s:form>
		
	
		
    </body>
</html>










