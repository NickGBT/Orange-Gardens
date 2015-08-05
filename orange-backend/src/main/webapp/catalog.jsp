<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author jtaylor -->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Catalog</title>
	</head>
	<body>
		<h1>Product Catalog</h1><br/>
		<!--<c:set var="items" value="${model.items}"/>-->
		Total Items Passed: <p>${fn:length(items)}</p>
		<ul>
			<!--<c:forEach items="${items.length}" var="product">-->
				<!--<li>Product Name: <c:out value="${product.name}"/>;-->
				<!-- this will probably work -->
				
				
			<!--</c:forEach>-->
		</ul>	
	</body>
</html>