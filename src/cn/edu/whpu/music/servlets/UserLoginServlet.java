package cn.edu.whpu.music.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.whpu.music.dao.UserDAO;
import cn.edu.whpu.music.dto.UserDTO;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("user_pwd");
		//����UserDAO�еķ���
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.queryUserById(userName, userPwd);
		//���ݲ�ѯ�������ҳ����ת
		
		if (userDTO ==null) {
			request.setAttribute("tips", "<label style='color:red'>��¼ʧ�ܣ��˺Ż��������</label>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//��¼�ɹ������û���¼�ɹ����Ͱ��û���Ϣ��ŵ�session������
			request.getSession().setAttribute("user", userDTO);
			response.sendRedirect("index.jsp");
		}
		
	}

}
