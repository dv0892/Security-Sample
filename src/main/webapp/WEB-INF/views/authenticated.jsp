<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Security authentication example</title>
</head>
<body>

<h2>Welcome to Spring Security authentication example!</h2>
Your username is: Authentication page

<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>