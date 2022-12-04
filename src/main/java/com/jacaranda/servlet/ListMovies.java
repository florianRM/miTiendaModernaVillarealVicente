package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.java.CRUDMovies;
import com.jacaranda.java.CRUDUser;
import com.jacaranda.java.Carrito;
import com.jacaranda.java.MovieCarrito;
import com.jacaranda.java.Movies;
import com.jacaranda.java.UtilsUsers;



/**
 * Servlet implementation class Login
 */
@WebServlet("/ListMovies")
public class ListMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMovies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Para cuando venga de comprar una pelicula, es decir vendrá de buy.jsp y la url no contendrá parámetros.
		doPost(request, response);
		
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupero la session
		HttpSession userSession = request.getSession();
		//recupero los parametros
		String usuario=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	Carrito carro = (Carrito) userSession.getAttribute("carrito");
    	if(carro==null) {
    		carro= new Carrito();
    		userSession.setAttribute("carrito", carro);
    	}
    	
    	

	    //compruebo si son nulos y si lo son recupero los atributos de la session
	    if((usuario ==null && password ==null)){	    	
	    	 usuario = (String)userSession.getAttribute("usuario");
		   	 password =(String)userSession.getAttribute("password");
	    	if((usuario ==null||usuario.isEmpty()) && (password ==null||password.isEmpty())){
	    		process(request, response);
	    	}
	    }
	    	//compruebo si el usuario es valido
	    	if(UtilsUsers.userIsValid(usuario, password)){
	            try {
	         	userSession.setAttribute("login", "True");
	         	userSession.setAttribute("usuario", usuario);
	         	userSession.setAttribute("password", password);
	         	
	            }catch (Exception e){
	            	process(request, response);
	            }

	    		//declaro que el texto va a ser html/ codificacion UTF-8
	    		response.setContentType("text/html;charset=UTF-8");
	    		// decimos que en la salida de datos se va a escribir lo siguiente
	    		PrintWriter out = response.getWriter();
	    		
	    		try {
	    			out.println("<!DOCTYPE html>"
	    					+ "<html>"
	    					+ "<head>"
	    					+ "<meta charset=\"UTF-8\">"
	    					+ "<title>Peliculas</title>"
	    					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styleTablePage.css\">"
	    					+ "</head>"
	    					+ "<body background=\"images/fondo2.jpg\">");
	    			
	    			List<Movies> listMovie =null;
	    			try {
	    				listMovie=CRUDMovies.getMovies();
	    			
	    			} catch (Exception e) {
	    				String message = e.getMessage();
	    				response.sendRedirect("error.jsp?msg=" + message);
	    			}
	    			
	    			out.println("<div align=\"left\"><img src=\"images/logo_movie-removebg.png\" width=\"110px\" height=\"100px\" id=\"logo\"></div>");
	    			if(CRUDUser.getUser(usuario).getAdmin()==1) {
						out.println("<div id=\"botonadd\" align=\"right\">\r\n"
								+ "		<a href=\"AddArticle.jsp\" ><button name=\"AddArticle\" id=\"addButton\" value=\"AddArticle\">Añadir Articulo</button></a> \r\n"
								+ "	</div>\r\n"
								+ "	<br>");
	    			}
	    			out.println("<div align=\"right\">"
	    					+ "<a href=\"Carrito.jsp\" <button name=\"carrito\" ><img height=\"70px\" width=\"70px\" src=\"images/carrito_1.png\"></button></a>");
	    			out.println("<h3>Artículos en el carrito: "+carro.getListPurchase().size()+"</h3>");
	    			out.println("<a href=\"Pedidos.jsp\" color=\"black\"><button name=\"pedidos\" id=\"addButton\"> Mis pedidos</button></a>");
	    			out.println("<h3> Usuario : "+usuario+"</h3>");
	    			out.println( "</div>");
	    			out.println("<div align=\"right\"><a href=\"Index.jsp\" align=\"right\" ><button align=\"right\"  name=\"CloseSesssion\" id=\"addButton\" value=<\"CloseSesssion\">Close Session</button></a></div><br>");
	    			
	    			out.println("<div>"
	    					+ "<table>"
	    					+ "<tr>"
	    					+ "<th>Id</th>"
	    					+ "<th>title</th>"
	    					+ "<th>Description</th>"
	    					+ "<th>Price</th>"
	    					+ "<th>Img</th>"
	    					+ "<th>Category</th>"
	    					+ "<th>Stock</th>"
	    					+ "<th>Zona de Compra</th>"
	    					+ "</tr>");
	    			
	    			
	    			
	    			
	    			Iterator<Movies> iterator = listMovie.iterator();
	    			while(iterator.hasNext()) { 
	    				//Itera cada linea de nuestra base datos y nos la muestra en la tabla correspondiente.
	    				
	    					Movies movie = new Movies();
	    					movie=iterator.next();
	    					Integer id = movie.getId();
	    					
	    					
	    					out.println("<tr>"
	    							+ "<td>"+movie.getId()+"</td>"
	    							+ "<td>"+movie.getTitle()+"</td>"
	    							+ "<td>"+movie.getDescription_movie()+"</td>"
	    							+ "<td>"+movie.getPrice()+"</td>");
	    					if(movie.getImg()!=null) {
	    						
	    						out.println("<td><img height=\"200px\" width=\\\"200px\\\"  alt=\"\"  src=\"./DowloadImg?id="+movie.getId()+"\">"+"</td>");
	    						
	    					}else {
//	    						<img  height=\"200px\" width=\"200px\"  alt=\"\"  src=\"images/noImage.png/>
	    						out.println("<td><p>No photo</p></td>");
	    					}out.println(
	    							 "<td>"+movie.getCategory().getGenres()+"</td>"
	    							+ "<td>"+movie.getStock()+"</td>");
	    							if(movie.getStock()==0||movie.getStock()==null) {
	    								out.println("<td><p>Sin stock</p></td>");
	    							}else {
	    								out.println("<td><form action=\"CarritoCompra.jsp\" method=\"post\">"
	    							+ "<input type=\"number\" name=\"cantidad\" min=1 max='"+movie.getStock()+"'>"
	    							+ "<br><button type=\"submit\" name=\"CarritoCompra\" id=\"CarritoCompra\" value="+movie.getId()+">Añadir al carrito</button><br></form></td>");
	    							}
	    							
	    					
	    					
	    					
	    					
  					
	    							
	    					
	    			}
	    			out.println("</table>"
	    					+ "</div>"
	    					+ "</body>"
	    					+ "</html>");
	    			
	    			
	    			
	    			
	    		} finally {
	    			//cerramos la salida de datos
	    			out.close();
	    		}
	            		
	       	} else { 
	       		process(request, response);
	       		
	  	 	}
	       	
	       	
		 }
		
		
		

	
	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
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
   				+ "                <h3 id=\"TextoChico\"><FONT color=\"black\">Error en el Inicio de sesión.<br><br>Pulsa el icono arriba a la izquierda para volver.</FONT></h3>"
   				+ "                <h7 id=\"codError\">Codigo de error: 404</h7>"
   				+ "            </div>"
   				+ "</body>"
   				+ "</html>");
   		
	}finally {
		out.close();
	}
   		
	}
	

}
