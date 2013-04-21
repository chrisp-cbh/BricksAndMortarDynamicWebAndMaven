<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hidie howdie Haydn helps himself

	<%
	List<String> names = new ArrayList<String>();
	names.add("Will");
	names.add("Kate");
	names.add("Harry");
	pageContext.setAttribute("names", names);

	String foo = "bar";
	pageContext.setAttribute("foo", foo);
%>
	<c:out value="names" />
	<br />
	<c:out value="foo" />
	<br /> Names:
	<c:forEach var="name" items="names">
	Name = ${name}<br />
	</c:forEach>
	
	<c:set var="myVariable" value="Test"/>
	
	My Variable : <c:out value="myVariable"/>



</body>
</html>