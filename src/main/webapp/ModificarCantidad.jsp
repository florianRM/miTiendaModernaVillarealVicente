<%@page import="com.jacaranda.java.MovieCarrito"%>
<%@page import="com.jacaranda.java.Movies"%>
<%@page import="com.jacaranda.java.CRUDMovies"%>
<%@page import="com.jacaranda.java.Carrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	Carrito carrito; 
	carrito= (Carrito) session.getAttribute("carrito");



	Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
	Integer newCantidad = Integer.valueOf(request.getParameter("cantidad_Modificar"));
	Integer movieId = Integer.valueOf(request.getParameter("id_objeto")); 
	CRUDMovies daoMovies = new CRUDMovies();
	Movies movie=daoMovies.getMovie(movieId);
	MovieCarrito movieCarrito = new MovieCarrito(movie,(newCantidad), (movie.getPrice()*cantidad));



	carrito.addItem(movieCarrito);%>



	<jsp:forward page="Carrito.jsp"></jsp:forward>

</body>
</html>