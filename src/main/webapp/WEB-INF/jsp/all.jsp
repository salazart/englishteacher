<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<h1>Persons</h1>
 
<table>
 <tr>
  <td width="50">Id</td>
  <td width="150">English</td>
  <td width="150">Russian</td>
  <td width="50">Iterator</td>
  <td width="50">Right iterator</td>
 </tr>
 <c:forEach items="${words}" var="word">
  <tr>
   <td><c:out value="${word.id}" /></td>
   <td><c:out value="${word.exampleWord}" /></td>
   <td><c:out value="${word.translateWord}" /></td>
   <td><c:out value="${word.iterator}" /></td>
   <td><c:out value="${word.correctIterator}" /></td>
  </tr>
 </c:forEach>
</table>
 
</body>
</html>