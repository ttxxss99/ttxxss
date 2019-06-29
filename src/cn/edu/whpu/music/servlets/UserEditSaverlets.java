package cn.edu.whpu.music.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

import cn.edu.whpu.music.dao.UserDAO;
import cn.edu.whpu.music.dto.UserDTO;


@WebServlet("/UserEditSaverlets")
public class UserEditSaverlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		
		 try {
			 	
				//�������� ���ļ��ϴ���
					SmartUpload su = new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					//�����ļ���ʽ
					su.setAllowedFilesList("jpg,png,bmp");
					//�����ļ���С
					su.setMaxFileSize(2*1024*1024);
					su.upload();
					//��su��ȡ���ı���Ϣ���ı�
					
					//��ȡ�ļ�
					Files fs =  su.getFiles();
					//���ڴ洢�û��ϴ���ͷ������Ŀ�е����·��
					String userPhoto ="photos/";
					//����
					
					if(fs.getCount()>0) {
						File f =fs.getFile(0);
						//�ļ���׺��
						String fileName = new Date().getTime() +"."+f.getFileExt();
						System.out.println(fileName);
						
						userPhoto  =userPhoto + fileName;
						//��ȡ��Ŀ��photosĿ¼�ڷ������е�·��
						String  path = getServletContext().getRealPath("photos").toString();
						//�ļ��ľ���·��
						f.saveAs(path+"/"+fileName);
					
					//��su��ȡ���ı���Ϣ
					Request req = su.getRequest();
					//String id = req.getParameter("userId");
					UserDTO user = (UserDTO) request.getSession().getAttribute("user");
					int  userId = user.getUserId();
					String userName = req.getParameter("userName");
					String userPwd = req.getParameter("userPwd");
					String userNick = req.getParameter("userNick");
					String userSex = req.getParameter("userSex");
					String userDesc = req.getParameter("userDesc");
			
						
					UserDAO udao = new UserDAO();
					UserDTO users = udao.queryUserById(userId);
					users.setUserPwd(userPwd);
					users.setUserNick(userNick);
					users.setUserPic(userPhoto);
					users.setUserSex(userSex);
					users.setUserDesc(userDesc);
					 boolean b = udao.updateUser(users);
					//���ݱ�����������ת
						String page = b?"index.jsp":"edit.jsp";
						String tipeStr =b?"<label style = 'color:green'>ע��ɹ������¼��</label>":"<label style = 'color:red'>ע��ʧ�ܣ����������룡</label>";
						if(b) {
							
							request.setAttribute("userName", userName);
							
						}
						request.setAttribute("tips", tipeStr);
						request.getRequestDispatcher(page).forward(request, response);
							
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
