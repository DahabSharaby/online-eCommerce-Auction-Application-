<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page </title>
    </head>
    <body>
      Welcome back 
	  <s:property value="#session.currentUser"/> 
	  <s:form action="logout" >
	  <s:submit value = "logout"/>
	  </s:form>
	  
	  <s:form action="viewAllItems" >
	  <s:submit value = "allItems"/>
        </s:form>
		
		<s:form action="addItems" >
	  <s:submit value = "addItems"/>
        </s:form>
		
		 <s:form action="viewAllUsers" >
	  <s:submit value = "viewAllUsers"/>
        </s:form>
		
		<s:form action="viewMyBids" >
		<s:textfield name="username" label="Please enter your username For verify:" />
	  <s:submit value = "viewMyBids"/>
        </s:form>
	
   	
    </body>
</html>

