<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Movie Details</title>
</head>
<body>

<div align="center">
  <p><strong><font size="+2">Welcome to Online Movie Review Database System</font></strong></p>
  <p>&nbsp;</p>
</div>


<div align="center">
  
  
  <table border="1">
    <tr>
      <td width="135"><div align="center"><strong>${name} -- Actor</strong></div></td>
    </tr>
    
    <c:forEach var ="m" items = "${actordetaillist}">
      <tr>
        <td><div align="center"><c:if test="${m.role == 'Actor'}">${m.title} </c:if></div></td>
      </tr>
    </c:forEach> 
  </table>
  <p>&nbsp;</p>
 </div>
 
   <div align="center">
     <table border="1">
       <tr>
         <td width="135"><div align="center"><strong>${name} -- Director</strong></div></td>
       </tr>
       
       <c:forEach var ="m" items = "${actordetaillist}">
         <tr>
           <td><div align="center"><c:if test="${m.role == 'Director'}">${m.title} </c:if></div></td>
         </tr>
       </c:forEach> 
       </table>
     <p>&nbsp;</p>
     
   </div>
   <div align="center">
     <table border="1">
       <tr>
         <td width="135"><div align="center"><strong>${name} -- Producer</strong></div></td>
       </tr>
       
       <c:forEach var ="m" items = "${actordetaillist}">
         <tr>
           <td><div align="center">
             <c:if test="${m.role == 'Producer'}">${m.title} </c:if></div></td>
         </tr>
       </c:forEach> 
  </table>
     <p>&nbsp;</p>
     
     
   </div>
<div align="center">
  <p><a href="http://localhost:8080/myapps/actor">Back</a></p>
</div>
</body>
</html>