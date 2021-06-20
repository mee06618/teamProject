package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.user.BoardListAction;
import action.user.UserAction;
import model.site.SiteDAO;
import model.site.SiteVO;
import util.SiteTitle;
import util.random;

@WebServlet("/convert")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	//	String cmd = request.getParameter("cmd");
		
	//	Action action = null;
	//	
	//	try {
			
	//		if (cmd.equals("user")) {
	//			action = new UserAction();
	//		}else if (cmd.equals("board")) {
	//		action = new BoardListAction();
	//	}
		
	//		action.excute(request, response);
			
	//	}catch(Exception e) {
	//	e.printStackTrace();
	//	}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		SiteVO vo = new SiteVO();
		SiteDAO dao = new SiteDAO();
		String now_address = javax.servlet.http.HttpUtils.getRequestURL(request).toString();		
		//String[] url = now_address.split("/");
		random ran = new random();
		SiteTitle site=new SiteTitle();
//		http://localhost:8020/master/a/baeldung��α��� ��Ʋ�� fuel ����/https://www.baeldung.com/kotlin/fuel
		String shortCode="";
		String origin=request.getParameter("url");
		if(dao.selectOrigin(origin)==0) {
		shortCode=ran.getRand();
		}else {
			shortCode=dao.getShort(origin);
			request.setAttribute("shortUri", shortCode);
			
		}
		while(true) {
			if(dao.contrastUri(shortCode)==0)
				break;
			shortCode=ran.getRand();
			
		
		}
		//String master = url[3];
		String url=request.getParameter("url");
		String name =site.getTitle(url);
		String blankless = name.replaceAll(" ", "");
		
		if(name!="" && dao.selectOrigin(origin)==0) {
			//SiteVO temp =dao.selectURI();
			//System.out.println("받은거 : "+temp.getOriginUri()); 
			
			System.out.println("사이트 이름 : "+name); //text
			System.out.println("빈칸 없는사이트 이름 : "+blankless); //blanklesstext
			System.out.println("변환된 사이트 : "+shortCode);//shotCode
			System.out.println("원래 사이트 : "+request.getParameter("url"));  //originUri
			
			
		
			
			
			vo.setMemberId(0);
			vo.setText(name);
			vo.setBlanklessText(blankless);
			vo.setShortCode(shortCode);
			vo.setOriginUri(request.getParameter("url"));
		
			int num=dao.convertURI(vo);
			if(num!=0)
			request.setAttribute("shortUri", shortCode);
			else
			System.out.println("실패");
		}
		//request.setAttribute("master", master);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

}
