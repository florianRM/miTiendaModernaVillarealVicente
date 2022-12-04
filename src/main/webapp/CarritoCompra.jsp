<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jacaranda.java.Carrito"%>
<%@page import="com.jacaranda.java.Movies"%>
<%@page import="com.jacaranda.java.CRUDMovies"%>
<%@page import="com.jacaranda.java.MovieCarrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
	


</div>
<% 

		
		Carrito carrito;
		carrito= (Carrito) session.getAttribute("carrito");
		try{
				
		Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
		 Integer movieId = Integer.valueOf(request.getParameter("CarritoCompra"));
		
		CRUDMovies daoMovies = new CRUDMovies();
		Movies movie =daoMovies.getMovie(movieId);
		
		MovieCarrito movieCarrito = new MovieCarrito(movie, cantidad, (movie.getPrice()*cantidad));	
		
		carrito.addItem(movieCarrito);
		
		 ServletContext context = this.getServletContext(); 
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ListMovies"); 
			
			
			dispatcher.forward(request, response);
		
		
		}catch(Exception e) {
 			response.sendRedirect("errorCarrito.jsp");
			
		}
		
		
		
		%> 
				
			
		
		
		

		
		

</body>
</html>