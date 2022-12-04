package com.jacaranda.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;

import com.jacaranda.java.CRUDCategory;
import com.jacaranda.java.CRUDMovies;
import com.jacaranda.java.Category;
import com.jacaranda.java.Conn;
import com.jacaranda.java.Movies;

/**
 * Servlet implementation class AddArticleMethod
 */
@WebServlet("/AddArticleMethod")
@MultipartConfig(maxFileSize=1024*1024*50, maxRequestSize =1024*1024*100 )
public class AddArticleMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleMethod() {
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
		// TODO Auto-generated method stub
		
		
		
		List<Integer> listCategory=CRUDMovies.MoviesMaxId();
		Integer id=null;
		String title=null;
		String description=null;
		Double price=null;
		Integer category_id=null;
		Integer stock=null;
		Part part =request.getPart("uploadImg");
		
		InputStream fileContent = part.getInputStream();
		Conn conection = new Conn();
		Blob blob =Hibernate.getLobCreator(conection.getSession()).createBlob(fileContent, fileContent.available());
	
		
		
		
		try {
			
		
			id = listCategory.get(0);
			
			title = request.getParameter("title");
			description = request.getParameter("description");
			price = Double.valueOf(request.getParameter("precio"));
			category_id = Integer.parseInt(request.getParameter("categorias"));
			stock=Integer.valueOf(request.getParameter("stock"));
			
			
			
			
			Category category=CRUDCategory.getCategory(category_id);
			
			
			if(CRUDMovies.getMovie(id+1)==null&&CRUDMovies.getMovieTitle(title)==null&& (title!=null&& !title.isEmpty()) && (description!=null&& !description.isEmpty()) && (price !=null&& !price.isNaN()) && category_id!=null&&category!=null) {
				Movies movie = new Movies(id+1,title.trim(), description.trim(), price, category, stock);
				
				movie.setImg(blob);
				CRUDMovies.saveMovie(movie);
//		response.sendRedirect(request.getContextPath()+"/ListMovies");
				
				
				ServletContext context = this.getServletContext(); 
				RequestDispatcher dispatcher = context.getRequestDispatcher("/ListMovies"); 
				
				
				dispatcher.forward(request, response);
				
				
			}else{
				
				process(request, response);
			}
			
		}catch (Exception e) {
			process(request, response);
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
   				+ "<form action=\"ListMovies\" method=\"post\">"
   				+ "<p><button type=\"submit\"><img src=\"images/logo_movie-removebg.png\" width=\"110px\" height=\"100px\" id=\"logo\" ></button></p>"
   				+ "</form>"
   				+ "            <hr>"
   				+ "            <div id=\"izq\">"
   				+ "                "
   				+ "                <img src=\"images/error_movie.jpg\" id=\"iconoError\">"
   				+ "            </div>"
   				+ "            <div id=\"der\">"
   				+ "                <h1 id=\"TextoGrande\"><FONT color=\"black\">¡Vaya!</FONT></h1>"
   				+ "                <h3 id=\"TextoChico\"><FONT color=\"black\">Error al añadir una película<br>Prueba<br><br>Pulsa el icono arriba a la izquierda para volver.</FONT></h3>"
   				+ "                <h7 id=\"codError\">Codigo de error: 404</h7>"
   				+ "            </div>"
   				+ "</body>"
   				+ "</html>");
   		
	}finally {
		out.close();
	}
   		
	}

}
