<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
    <title>Welcome</title>
   <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<title>Insert title here</title>
</head>
<body>
	<h1>List of Employees</h1>
	<table border = "1">
		<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Date of Birth</th>
		</tr>
        <c:forEach items="${list}" var="e">
			<tr>
				<td>${e.name}</td>
				<td>${e.gender}</td>
				<td>${e.department}</td>
				<td>${e.dob}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>