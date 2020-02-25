<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String conPath = request.getContextPath(); %>

<form action="<%=conPath%>/create">
	author : <input type="text" name="writer" value="${dto.writer}"> <br>
	content: <input type="text" name="content" value="${dto.content}">
	<input type="submit" value="전송">
</form>
</body>
</html>