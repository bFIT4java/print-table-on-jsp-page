<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myform" onsubmit="return validate();" action="http://localhost:8082/OMS1/ValidatorServlet" method = "post">
<center>
	
	<%
		
	//grabs vectors from servlet and sets it to local vector in the jsp page
		Object id = request.getAttribute("productId");
		Vector productId = (Vector)id;
		Object name = request.getAttribute("productName");
		Vector productName = (Vector)name;
		Object price = request.getAttribute("productPrice");
		Vector productPrice = (Vector)price;
		//creates iterater to go through the vectors in print them out.
		//ANY JAVA CODE THAT YOU DO NOT WANT TO PRINT WORDS MUST BE SURROUNDED BY <% (OPEN AND CLOSE)
		Iterator itId = productId.iterator();
		Iterator itName = productName.iterator();
		Iterator itPrice = productPrice.iterator();
		

		 %>	
<table border = "1" color="FF0000">
<tr><td>Product ID</td><td>Product Name</td><td>Product Price</td></tr>

<%//started the iterator and display information in the vector 
while(itId.hasNext()){%>
<tr><td> <%out.print(itId.next());%></td><td><%out.print(itName.next());%></td><td><%out.print(itPrice.next());%></td></tr>
<% }%>
		
</table>

</center>
</form>
</body>
</html>
