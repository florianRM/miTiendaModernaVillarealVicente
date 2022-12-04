package com.jacaranda.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.java.CRUDMovies;

/**
 * Servlet implementation class DowloadImg
 */
@WebServlet("/DowloadImg")
public class DowloadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DowloadImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDMovies daoMovies  = new CRUDMovies();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Blob img = daoMovies.getMovie(id).getImg();
		
		byte[] blobFiles =null;
		ServletOutputStream ouputStream =null;
		
		try {
			blobFiles = img.getBytes(1, (int) img.length());
		}catch (Exception e) {
			throw new ServletException("error desconocido");
		}
		
		ouputStream=response.getOutputStream();
		
		ouputStream.write(blobFiles);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
