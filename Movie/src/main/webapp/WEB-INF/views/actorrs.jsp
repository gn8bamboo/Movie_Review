<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Movie Information</title>
</head>
<body>

<div align="center">
  <p><strong><font size="+2">Welcome to Online Movie Review Database System</font></strong></p>
  <p>&nbsp;</p>
</div>


<div align="center">
  <table border="1">
    
    <tr>
      <td><div align="center"><strong>${name} -- Search Result</strong></div></td>
    </tr>
    
    <c:forEach var ="actor" items = "${actorrslist}">
      <tr>
         <td><a href="http://localhost:8080/myapps/actordetail.action?aname=${actor.aname} "><div align="center">${actor.aname}</div></a></td>
      </tr>
    </c:forEach>
    
  </table>
</div>

<div align="center">
  <p><a href="http://localhost:8080/myapps/menu">Back</a></p>
</div>
</body>
</html>