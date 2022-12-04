<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 		<link rel="stylesheet" type="text/css" href="css/mvp.css">
</head>
<body>
<div align="center">
<form action="RegistrerUser" method="post" id="addUser">			
		
			<h3>Rellene los siguientes datos:</h3>
			
					Username: <input type="text" name="username" id="username" required><br>
					
					Password: <input type="password" name="password"  id="password"  required><br>
					
					First_name:<input type="text" name="first_name" id="first_name" required>
					
					
					Last_name:<input type="text" name="last_name" id="last_name" required>
					
					Fecha de nacimiento: <input type="date" name="date" required><br>
					
					Género: Hombre<input type="radio" name="gender" value="Male" required>
					Mujer <input type="radio" name="gender"  value="Female" required>
					
					
					 <input type="hidden" name="admin" value="0">
					<br>
					<button type="submit" id="loginButton" class="login_button">Enviar</button>
					<button type="reset" id="resetButton" class="login_button">Borrar</button>
					<button onclick="location.href='Index.jsp'" value="Volver al Inicio" />Inicio</button>
		
		
					</form>
</div>

</body>
</html>