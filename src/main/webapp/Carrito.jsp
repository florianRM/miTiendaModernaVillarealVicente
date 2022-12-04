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
	<title>Carrito</title>
	<link rel="stylesheet" type="text/css" href="css/styleTablePage.css">
</head>
<body background="images/fondo2.jpg">
	<div id="header">
		 <img src="images/logo_movie-removebg.png" width="110px" height="100px" id="logo">
		 
		 <span id="welcome"><h4>Sesion: <%=userSession %></h4></span>
		 
		
		 <hr>

	</div>

	<br>
	
	<div>
		<table>
		
		
			<tr>
				
				<th>Pelicula</th>
				<th>Cantidad</th>
				<th>Precio</th>
				
				
			</tr>
			
		
		<%
		List<MovieCarrito> listMoviesCarrito = carrito.getListPurchase();
		Iterator<MovieCarrito> iterator = listMoviesCarrito.iterator();  
		MovieCarrito item = new MovieCarrito();
		Double price=0.0;
		
		if(listMoviesCarrito.size()==0||listMoviesCarrito==null){
			%>
			<h1>No hay articulos</h1>
		<%}else{
		
		while(iterator.hasNext()) { //Itera cada linea de nuestra base datos y nos la muestra en la tabla correspondiente.
			
			 item = iterator.next();
			
		%>
			
			<tr>
				<td><%=item.getMovie().getTitle()%></td>
				<td><%=item.getCantidad() %>
				<form action="ModificarCantidad.jsp" method="post">
				<input type="number" name="cantidad_Modificar" min=1 max=<%=item.getMovie().getStock()%>>
				<input type="hidden" value=<%=item.getMovie().getId()%> name="id_objeto">
				<input type="hidden" value=<%=item.getCantidad()%> name="cantidad">
				<button type="submit" name="modificarCantidad" id="CarritoCompra">Modificar Cantidad</button></form>
				</td>
				<td><%=item.getPrecioTotal()%></td>
				<%price=price+item.getPrecioTotal();%>
			</tr>
			
			 
		<%}
		}%>
		
		
		<tr>
			<td><b>Precio Total: </b></td>
			<td colspan="2"><b><%=Math.round(price*100.0)/100.0 %></b></td>
		</tr>
		
		</table>
		<br>
		<div id="botonadd" align="right">
			<%if(listMoviesCarrito.size()==0||listMoviesCarrito==null){
			%>
			<a href="ListMovies"><button name="precio" id="addButton">Back</button></a>
			<a href="vaciarCarrito.jsp"><button type="submit"
					name="vaciarCarrito" id="addButton">Vaciar carrito</button></a>

			<%}else{
				%>
			<a href="Buy.jsp"><button name="precio" id="addButton">Comprar</button></a>
			<a href="ListMovies"><button name="precio" id="addButton">Back</button></a>
			<a href="vaciarCarrito.jsp"><button type="submit"
					name="vaciarCarrito" id="addButton">Vaciar carrito</button></a>
		</div>
		<% }%>
		
		
	
		
			
		
			
	</div>

</body>
</html>