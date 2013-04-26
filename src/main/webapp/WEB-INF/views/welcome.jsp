<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="java.util.*" %>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>Products</h3>
	<c:forEach items="${model.products}" var="prod">
		<c:out value="${prod.description}" />
		<i>$<c:out value="${prod.price}" /></i>
		<br>
		<br>
	</c:forEach>

	<br>
	<ul>
		<li><a href="<c:url value="createsale.htm"/>">Create new Sale</a></li>
		<li><a href="<c:url value="priceincrease.htm"/>">Increase
				Prices</a></li>
	</ul>
	<br>


<h3>hello world</h3>
</body>
</html>