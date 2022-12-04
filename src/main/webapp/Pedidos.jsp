<%@page import="com.jacaranda.java.ComparatorDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.jacaranda.java.User"%>
<%@page import="com.jacaranda.java.CRUDPurchase"%>
<%@page import="com.jacaranda.java.CRUDUser"%>
<%@page import="com.jacaranda.java.Purchase"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.jacaranda.java.MovieCarrito"%>
<%@page import="com.jacaranda.java.Carrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
 	String isSession = (String) session.getAttribute("login");
	String userSession = (String) session.getAttribute("usuario");
	 Carrito carrito= (Carrito) session.getAttribute("carrito");
	
	if(isSession == null && userSession == null){
		response.sendRedirect("error.jsp?msg=No tienes permisos, haz login.");
		
	}  
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pedidos</title>
	<link rel="stylesheet" type="text/css" href="css/styleTablePage.css">
</head>
<body background="images/fondo2.jpg">
	<div id="header">
		 <img src="images/logo_movie-removebg.png" width="110px" height="100px" id="logo">
		 
		 <span id="welcome"><h4>Sesion: <%=userSession %></h4><a href="CloseSession.jsp" ></a></span>
		 
		
		 <hr>

	</div>

	<br>
	
	<div>
		<table>
		
		
			<tr>
				
				<th>Pelicula</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Fecha</th>
				<th>Usuario</th>
				
				
			</tr>
			
		
		<%
		
		List<Purchase> listPurchase = CRUDPurchase.getListPurchase(userSession);
		ComparatorDateTime c= new ComparatorDateTime();
		listPurchase.sort(c);
		Iterator<Purchase> iterator = listPurchase.iterator();  
		Purchase item = new Purchase();
		
		while(iterator.hasNext()) { //Itera cada linea de nuestra base datos y nos la muestra en la tabla correspondiente.
			
			 item = iterator.next();
			
		%>
			<tr>
				<td><%=item.getId_movie().getTitle()%></td>
				<td><%=item.getQuantity()%>
				<td><%=item.getPrice()%>
				<td><%=DateTimeFormatter.ISO_LOCAL_DATE.format(item.getDate())+"   "+ DateTimeFormatter.ISO_LOCAL_TIME.format(item.getDate())%>
				<td><%=item.getUser().getUsername()%>
				
			</tr>
			
			 
		<%
		}
		%>
		
		
		</table>
		<br>
		<div id="botonadd" align="right">
		<a href="ListMovies" ><buton name="precio" id="addButton">Back</button></a> 
			</div>
	</div>

</body>
</html>