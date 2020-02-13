<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormmatConfirmation</title>
</head>
<body>

<%
List<String> array = (List<String>)request.getAttribute("formmat");

for(int i = 0;array.size() > i;i++ ){ %>

	<%= array.get(i) %>
	<br>
<% } %>

</body>
</html>