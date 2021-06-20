package action.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class BoardListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RequestDispatcher rd = request.getRequestDispatcher("/board.jsp");
		rd.forward(request, response);
	}

}
