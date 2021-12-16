<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Delivery Staff</title>
    
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
  <h1>Update Delivery Staff</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	delivery_id:<input type="text" name="delivery_id" value="${delivery_staff.delivery_id}" disabled/>
	<br/>
	delivery_staff_id:<input type="text" name="delivery_staff_id" value="${delivery_staff.delivery_staff_id}" disabled/>
	<br/>
	delivery_date	：<input type="text" name="delivery_date" value="${delivery_staff.delivery_date}" disabled/>
	<br/>
	supplier_id	：<input type="text" name="supplier_id" value="${delivery_staff.supplier_id}" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Delivery_staffServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="delivery_id" value="${delivery_staff.delivery_id}"/>
	delivery_staff_id：<input type="text" name="delivery_staff_id" value="${form.delivery_staff_id}"/>
	<span style="color: red; font-weight: 900">${errors.delivery_staff_id }</span>
	<br/>
	delivery_date	：<input type="text" name="delivery_date" value="${form.delivery_date}"/>
	<span style="color: red; font-weight: 900">${errors.delivery_date }</span>
	<br/>
	supplier_id	：<input type="text" name="supplier_id" value="${form.supplier_id}"/>
	<span style="color: red; font-weight: 900">${errors.delivery_date }</span>
	<br/>
	<input type="submit" value="Update Delivery Staff"/>
</form>

</body>
</html>
