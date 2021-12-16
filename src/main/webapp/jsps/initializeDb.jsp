<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
   <head>
      <title>employees Operation</title>
   </head>

   <body>
     
 	<h1>Database Initialized</h1>
   </body>
   <button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</html>