package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.java.CRUDUser;
import com.jacaranda.java.Md5encript;
import com.jacaranda.java.User;

/**
 * Servlet implementation class RegistrerUser
 */
@WebServlet("/RegistrerUser")
public class RegistrerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Recojo los parametros y le hago un trim para que pueda añadir nombres con espacio.
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String first_name = request.getParameter("first_name");
		LocalDate date=null;
		String last_name = request.getParameter("last_name");
		try {
			 date = LocalDate.parse(request.getParameter("date"));
			
		}catch (Exception e) {
			process(request, response);
		}
		Integer admin = Integer.valueOf(request.getParameter("admin"));
		String gender = request.getParameter("gender");
		
		//compruebo que no sea nulo cad parametro
		
			//busco al usuario en la base de datos y compruebo que no existe. Compruebo que la contraseña es superior a 7 caracteres.
			if(CRUDUser.getUser(username)==null && password.length()>=7&&(username!=null||username.isEmpty()) && (password!=null||password.isEmpty()) && (first_name!=null||first_name.isEmpty()) && (last_name!=null||last_name.isEmpty())&& date!=null &&admin!=null&& gender!=null){
				Period overEighteen = Period.between(date, LocalDate.now());
				
				if(overEighteen.getYears() < 18) {
					process(request, response);
				} else {
					User u  = new User(username.trim(),Md5encript.getMD5(password).trim(),first_name.trim(),last_name.trim(),
							date,gender,admin);
					CRUDUser.saveUser(u);
					response.sendRedirect(request.getContextPath()+"/Index.jsp");
				}
		
			
		}else{
			response.setContentType("text/html;charset=UTF-8");
       		PrintWriter out = response.getWriter();
       		
       	try {
       		process(request, response);
       		
       	}finally {
			out.close();
		}
       		
  	 	
		}
	}
	protected void process (HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
		out.println("<!DOCTYPE html>"
   				+ "<html>"
   				+ "<head>"
   				+ "<meta charset=\"UTF-8\">"
   				+ "<title>Error 404</title>"
   				+ "		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styleError.css\">"
   				+ " "
   				+ "</head>"
   				+ "<body background=\"images/fondo_movie.jpg\">"
   				+ "      <a href=\"Index.jsp\"><img src=\"images/logo_movie-removebg.png\" width=\"110px\" height=\"100px\" id=\"logo\"></a>"
   				+ "            <hr>"
   				+ "            <div id=\"izq\">"
   				+ "                "
   				+ "                <img src=\"images/error_movie.jpg\" id=\"iconoError\">"
   				+ "            </div>"
   				+ "            <div id=\"der\">"
   				+ "                <h1 id=\"TextoGrande\"><FONT color=\"black\">¡Vaya!</FONT></h1>"
   				+ "                <h3 id=\"TextoChico\"><FONT color=\"black\">Error al añadir el usuario<br><br><br>Pulsa el icono arriba a la izquierda para volver.</FONT></h3>"
   				+ "                <h7 id=\"codError\">Codigo de error: 404</h7>"
   				+ "            </div>"
   				+ "</body>"
   				+ "</html>");
   		
	}finally {
		out.close();
	}
   		
	}

}
