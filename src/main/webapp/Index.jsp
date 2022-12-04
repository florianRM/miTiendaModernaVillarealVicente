<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title>Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<%session.invalidate(); %>
<body background="images/fondo_movie.jpg">
	<div id="container">
    	<img src="images/logo_movie-removebg.png" width="110px" height="100px" id="logo">
                     
        <div id="centroLogin">
    
        	<form action="ListMovies"  method="post">
            	<h1 id="titulo">MoviesVillarreal</h1>
							
			
				<!--Formulario de login que enviará la información a CheckLogin.jsp y hará las comprobaciones-->
		
	            <p id="textoUser">Usuario:
	            <br>	            
	            <input type="text" required name="username" id="username" >  <img alt="imagen" src="images/user.png"></p>
	            
	            <p id="textoContrasena">Contraseña: 	             
	            <input type="password" required name="password" id="password" >  <img alt="password" src="images/password.png"></p>
	            
                <p><a href="Registro.jsp"><b>Registrese aquí</b></a>   <input type="submit" id="Enviar" value="Enviar"></p>
               
          	</form>
       	</div>
   	</div>

</body>
</html>