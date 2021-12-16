<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Customer Output</title>
    
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
  <h1>Read Customer Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	customer_id    :<input type="text" name="customer_id" value="${customer.customer_id}" disabled/>
	<br/>
	customer_name：<input type="text" name="customer_name" value="${customer.customer_name}" disabled/>
	<br/>
	customer_address	：<input type="text" name="customer_address" value="${customer.customer_address}" disabled/>
	<br/>
	customer_age	：<input type="text" name="customer_age" value="${customer.customer_age}" disabled/>
	<br/>
	delivery_id    :<input type="text" name="delivery_id" value="${customer.delivery_id }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
