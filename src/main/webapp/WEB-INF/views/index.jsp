<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<h3>
		Press calculate putton to get the weighted average or <br /> press
		sort button to get the student list sorted
	</h3>
	<form:form method="POST">
		<div>
			<input type="submit" name="calc" value="Calculate">
			<input type="submit" name="sort" value="Sort">
		</div>
		<table>
			<c:choose>
				<c:when test="${param.sort == 'Sort'}">
					<table border="1">
						<tr>
							<td>Student Names</td>
							<td>Student Average Grade</td>
						</tr>
						<tr>
							<c:forEach items="${studentMap}" var="entry">
								<tr>
									<td>${entry.key}</td>
									<td>${entry.value}</td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</c:when>
				<c:when test="${param.calc == 'Calculate'}">
					<tr>
						<td>Student Weighted average grade:</td>
						<td>${weighted}</td>
					</tr>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</table>
	</form:form>
</body>
</html>


