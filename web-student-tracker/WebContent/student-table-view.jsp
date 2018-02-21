<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monster University</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<table style="width:50%">
  <tr>
    <th>Monster First Name</th>
    <th>Monster Last Name</th> 
    <th>Email</th>
    <th>Scare Number</th>
  </tr>
  
  <c:forEach var="tempMonster" items="${monsterList}">
  <tr>
    <td><c:out value="${tempMonster.firstName }"/></td>
    <td><c:out value="${tempMonster.lastName }"/></td>
    <td><c:out value="${tempMonster.email }"/></td>
    <td><c:out value="${tempMonster.scareScore}"/></td>
  </tr>
  </c:forEach>
  
</table>

<input type="button" value="Add Student" onclick="window.location.href='add-monster.jsp'; return false;">

<body>

</body>
</html>