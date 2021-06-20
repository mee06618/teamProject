package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.site.SiteDAO;


@WebServlet("/s/*")
public class ShiftController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShiftController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		SiteDAO dao = new SiteDAO();
		String now_address = javax.servlet.http.HttpUtils.getRequestURL(request).toString();		
		String[] url = now_address.split("/");
	


	
	
		if(dao.unContrastUri(url[4])!="") {
		
			String temp = dao.unContrastUri(url[4]);			
			
		
			
			response.sendRedirect(temp);
			
		}else {
			response.sendRedirect("http://localhost:8020/index.jsp");

			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}

}
