<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Client</title>
</head>
<body>
<h1>Contact Us</h1>
<form action="sendEmail.htm" method="POST">
<table>
<tr>
<td allign="right"><b>TO :</b></td>
<td>
<input type="text" name="email"  size="75">
</td>
</tr>
<tr>
<td allign="right"><b>Subject :</b></td>
<td>
<input type="text" name="subject"  size="75">
</td>
</tr>
<tr>
<td allign="right"><b>Message :</b></td>
<td>
<textarea name="message" rows="6" cols="75"></textarea>
</td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" value="Send">
</td>
</tr>
</table>
</table>

</form>
</body>
</html>