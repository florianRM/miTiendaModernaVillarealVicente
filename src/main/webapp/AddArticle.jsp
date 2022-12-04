<%@page import="com.jacaranda.java.CRUDCategory"%>
<%@page import="com.jacaranda.java.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--      <%
 	String isSession = (String) session.getAttribute("login");
	String userSession = (String) session.getAttribute("usuario");
	
	if(isSession == null && userSession == null){
		response.sendRedirect("error.jsp?msg=No tienes permisos, haz login.");
	}  
%>  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Article</title>
<link rel="stylesheet" type="text/css" href="css/mvp.css">
</head>
<body>
	<div align="center">
<form action="AddArticleMethod" method="post" id="addUser" enctype="multipart/form-data">			
		
			<h3>Rellene los siguientes datos:</h3>
					
					Título: <input type="text" name="title" id="title" required><br>
					
					Descripción de la Película: <textarea rows="5" cols="50" name="description" id="description" required></textarea><br>
					
					Precio:<input type="number" step="any" name="precio" id="precio" required>
					
					
					Categoría:
					<br>
					<select id="categorias" name="categorias">
					
					<%
						ArrayList<Category> listCategory = CRUDCategory.getCategory();
						for(Category c: listCategory){
							%>
							<option value="<%=c.getId()%>"><%=c.getGenres() %></option>
					<%-- 	value=<%c.getId();	 --%>
						<%} %>
					
					
						
					
						
					</select>
					<input type="hidden" value="30" name="stock" id="stock">
					
					<input type="file" name="uploadImg"  id="uploadImg"required>
					<br>
					<button type="submit" id="AddArticleButton" class="AddArticleButton">Enviar</button>
					<button type="reset" id="resetButton" class="AddArticleButton">Borrar</button>
					<!-- <button onclick="location.href=''"Volver al Inicio" />Inicio</button> -->
	
		
					</form>
					<form action="ListMovies" method="post">
						<button>Back</button>
					</form>
</div>
	
	

</body>
</html>