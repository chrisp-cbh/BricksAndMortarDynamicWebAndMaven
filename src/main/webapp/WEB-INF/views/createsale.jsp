<!DOCTYPE html>
<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="style.css">
		<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
		<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />" rel="stylesheet" type="text/css"/>
		
		<script src="script.js"></script>
		<title>Create a new Sale</title>
	</head>
	<body>
		<div id="formsContent">
			<form:form id="form" method="post" modelAttribute="saleBean" cssClass="cleanform">
				<div class="header">
		  			<h2>Create Sale</h2>
		  			<c:if test="${not empty message}">
						<div id="message" class="success">${message}</div>	
			  		</c:if>
			  		<s:bind path="*">
		  				<c:if test="${status.error}">
					  		<div id="message" class="error">Form has errors</div>
			  			</c:if>
			  		</s:bind>
				</div>
		  		<fieldset>
		 	 		<legend>New sale details</legend>
		  			<form:label path="salesAssistant">
		  				Sales Assistant <form:errors path="salesAssistant" cssClass="error" />
			 		</form:label>
			  		<form:input path="salesAssistant" />
		  			<form:label path="tillId">
		  				Till Id <form:errors path="tillId" cssClass="error" />
			 		</form:label>
			  		<form:input path="tillId" />
		  			<form:label path="timeStamp">
		  				Time Stamp <form:errors path="timeStamp" cssClass="error" />
			 		</form:label>
			  		<form:input path="timeStamp" />
			  	</fieldset>
	
				<p><button id="submit" type="submit">Submit</button></p>
			</form:form>
		</div>
		<a href="<c:url value="/"/>">Home</a>
	</body>
</html>