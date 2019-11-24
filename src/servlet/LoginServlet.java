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
 * servlet�޸ĵ�����
 * @author �Ķ���
 *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�Ե�¼���в���
		//�������ı����ʽ
		request.setCharacterEncoding("UTF-8");

		//��ȡ�û���Ϣ
		String account  = request.getParameter("account");
		String upwd = request.getParameter("upwd");
		
		HttpSession session = request.getSession();
		ServletContext application = request.getSession().getServletContext();
		
		
		//����Java biz���е�¼����
		UserBiz ub = new UserBizimpl();
		User user = ub.login(account, upwd);
		if(user!=null){
			//��¼�ɹ�
			//session�б����û���Ϣ  ��ȡ�û����󣬲���ֻ��ȡ�û�������
			session.setAttribute("login", user);
			
			//ҳ����ת��������ҳ
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else{
			//�û���¼������ʾ��¼������Ϣ
			session.setAttribute("status", "fail");
			//���ɹ�  ���ص���¼ҳ��
			response.sendRedirect("Login.jsp");
			
		}
	}

}
