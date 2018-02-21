<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Students</title>
</head>

<form action="monsterServlet" method="GET">
	<input type="hidden" name="command" value="ADD" />
	<table>
		<tbody>
			<tr>
				<td><label>First name:</label></td>
				<td><input type="text" name="firstName" /></td>
			</tr>

			<tr>
				<td><label>Last name:</label></td>
				<td><input type="text" name="lastName" /></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><input type="text" name="email" /></td>
			</tr>

			<tr>
				<td><label>Scare Score:</label></td>
				<td><input type="text" name="scareScore" /></td>
			</tr>

			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
			</tr>

		</tbody>
	</table>
</form>

<body>

</body>
</html>