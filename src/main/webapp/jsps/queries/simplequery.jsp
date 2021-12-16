<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">Delivery Staff Whose Delivery ID != 'DEL345' ordered by Delivery Date</h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Delivery ID</th>
		<th>Delivery Staff ID</th>
		<th>Delivery Date</th>
		<th>Supplier ID</th>
	</tr>
<c:forEach items="${DeliveryStaff}" var="delivery_staff">
	<tr>
		<td>${delivery_staff.delivery_id}</td>
		<td>${delivery_staff.delivery_staff_id}</td>
		<td>${delivery_staff.delivery_date}</td>
		<td>${delivery_staff.supplier_id}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
