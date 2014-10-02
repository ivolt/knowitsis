<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div id="menu" style="background-color:#F5F5F5;width:150px;margin-bottom:auto;height:410px;float:left;">

<b>Menu</b><br>
<a href="/knowitsis">Start page</a><br>
<a href="upload">Amet</a><br>
<a href="calculator">Ametid Väeosas</a><br>
</div>
	<h3>${message}</h3>

	<form:form method="post" commandName="upload" action="uploadNewFile"
		enctype="multipart/form-data">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td><label>File</label></td>
					<td><input id="file" class="form-control" name="file"
						type="file" /></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn btn-primary" type="submit"
						value="Upload" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<form:form method="post" commandName="calcweighted" action="calculateWithTestData">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td colspan="3"><input type="submit" value="Calculate" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>