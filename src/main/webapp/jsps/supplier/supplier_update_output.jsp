<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Supplier</title>
    
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
  <h1>Update Supplier</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Supplier_id    :<input type="text" name="supplier_id" value="${supplier.getSupplier_id() }" disabled/>
	<br/>
	
	Supplier_name ：<input type="text" name="supplier_name" value="${supplier.getSupplier_name()}" disabled/>
	<br/>
	Delivery_id	：<input type="text" name="delivery_id" value="${supplier.getDelivery_id()}" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/SupplierServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="supplier_id" value="${supplier.getSupplier_id()}"/>
	
	Supplier_name：<input type="text" name="supplier_name" value="${form.supplier_name}"/>
	<span style="color: red; font-weight: 900">${errors.supplier_name }</span>
	<br/>
	Delivery_id	：<input type="text" name="delivery_id" value="${form.delivery_id }"/>
	<span style="color: red; font-weight: 900">${errors.delivery_id }</span>
	<br/>
	<input type="submit" value="Update Supplier"/>
</form>

</body>
</html>
