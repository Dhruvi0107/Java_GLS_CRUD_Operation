<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book Page</title>
</head>
<body align="center">
	<h1>ADD BOOK</h1>
	<form action="add_books" method="post">
		Book Name : <input type="text" name="bname" placeholder="Enter Your Book Name.."><br><br>
		Book Price : <input type="text" name="bprice" placeholder="Enter Your Book Price.."><br><br>
		Book Pages : <input type="text" name="bpages" placeholder="Entet Your Book Pages.."><br><br>
		Author Name : <input type="text" name="aname" placeholder="Enter Your Book Author Name.."><br><br>
		
		<input type="submit" value="REGISTER">
	</form>
</body>
</html>