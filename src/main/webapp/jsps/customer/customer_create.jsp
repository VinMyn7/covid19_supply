<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create customer</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Create customer</h1>
<form action="<c:url value='/CustomerServletCreate'/>" method="post">
	customer_id    :<input type="text" name="customer_id" value="${form.customer_id }"/>
	<span style="color: red; font-weight: 900">${errors.customer_id }</span>
	<br/>
	customer_name：<input type="text" name="customer_name" value="${form.customer_name }"/>
	<span style="color: red; font-weight: 900">${errors.customer_name }</span>
	<br/>
	customer_address	：<input type="text" name="customer_address" value="${form.customer_address }"/>
	<span style="color: red; font-weight: 900">${errors.customer_address }</span>
	<br/>
	customer_age	：<input type="text" name="customer_age" value="${form.customer_age }"/>
	<span style="color: red; font-weight: 900">${errors.customer_age }</span>
	<br/>
	delivery_id    :<input type="text" name="delivery_id" value="${form.delivery_id }"/>
	<span style="color: red; font-weight: 900">${errors.delivery_id }</span>
	<br/>
	<input type="submit" value="Create Customer"/>
</form>
  </body>
</html>
