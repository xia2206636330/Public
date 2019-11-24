package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Biz.UserBiz;
import Biz.impl.UserBizimpl;
import Dao.entity.User;
/**
 * servlet修改登錄頁面
 * @author 夏冬旺
 *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对登录进行操作
		//设置中文编码格式
		request.setCharacterEncoding("UTF-8");

		//获取用户信息
		String account  = request.getParameter("account");
		String upwd = request.getParameter("upwd");
		
		HttpSession session = request.getSession();
		ServletContext application = request.getSession().getServletContext();
		
		
		//调用Java biz进行登录处理
		UserBiz ub = new UserBizimpl();
		User user = ub.login(account, upwd);
		if(user!=null){
			//登录成功
			//session中保存用户信息  获取用户对象，不能只获取用户的名字
			session.setAttribute("login", user);
			
			//页面跳转到新闻首页
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else{
			//用户登录错误显示登录错误信息
			session.setAttribute("status", "fail");
			//不成功  跳回到登录页面
			response.sendRedirect("Login.jsp");
			
		}
	}

}
