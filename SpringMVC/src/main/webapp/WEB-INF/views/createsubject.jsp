<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}"/resources/css/main.css">
</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="subject">

	<table class="formtable">
		<tr> <td> Subject_code: </td> <td> <sf:input type = "text" path="subject_code"/> <br/>
			<sf:errors path="name"  class="error" />  </td> </tr>
		<tr> <td> Year: </td> <td> <sf:input type = "text" path="year"/> </td> </tr>
		<tr> <td> Division: </td> <td> <sf:input type = "text" path="division"/> </td> </tr>
		<tr> <td> Name: </td> <td> <sf:input type = "text" path="name"/> </td> </tr>
		<tr> <td> Semester: </td> <td> <sf:input type = "text" path="semester"/> </td> </tr>
		<tr> <td> Credit: </td> <td> <sf:input type = "text" path="credit"/> </td> </tr>
		<tr> <td></td> <td> <input type = "submit" value="추가"/> </td> </tr>
	</table>

</sf:form>

</body>
</html>