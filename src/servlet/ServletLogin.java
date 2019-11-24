package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * 
 * @author 夏冬旺
 *
 */
public class ServletLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//對中文進行編碼
		request.setCharacterEncoding("UTF-8");
		
		//獲取用戶賬號信息
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		//System.out.println(uname+""+upwd);
		if (uname.equals("k950301") && upwd.equals("123456")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("mylogin.jsp");
		}
	}

}
