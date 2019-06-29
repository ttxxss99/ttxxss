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


@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserDTO userDTO = null;
			//request.setCharacterEncoding("UTF-8");
		try {
			SmartUpload sUpload = new SmartUpload();
			sUpload.initialize(getServletConfig(), request, response);
			sUpload.setAllowedFilesList("jpg,png,bmp");
			sUpload.setMaxFileSize(2*1024*1024);//�����ϴ�2M���ļ�
			sUpload.upload();
			//��supload������ȡ���ı���Ϣ���ļ�
			//userPhoto���ڴ洢�û��ϴ���ͷ������Ŀ�е����·��
			String userPhoto = "photos/";
			Files fs =  sUpload.getFiles();
//			System.out.println(fs.getCount());
			if(fs.getCount()>0) {
				File f =fs.getFile(0);
				
				//��ȡ��Ŀ��photosĿ¼�ڷ������е�·��
				String fileName = new Date().getTime() + "." + f.getFileExt();
				userPhoto = userPhoto + fileName;
				String path = getServletContext().getRealPath("photos").toString();
				
				f.saveAs(path+"/"+fileName);//��ʾ����·��
				
			}
			//��su��ȡ���ı���Ϣ
			
			Request request2 = sUpload.getRequest();
		//	int userId = request2.getParameter("");
			String userName = request2.getParameter("userName");
			String userPwd = request2.getParameter("userPwd");
			String rePwd = request2.getParameter("rePwd");
			String userNick = request2.getParameter("userNick");
			String userSex = request2.getParameter("sex");
			String userDesc = request2.getParameter("userDesc");
			userDTO = new UserDTO( userName , userPwd, userNick, userSex, userPhoto, userDesc);
			UserDAO userDAO = new UserDAO();
//			System.out.println(userName);
//			System.out.println(userPwd);
			boolean b = false;
			 //���ݽ����ת
			if(userPwd==rePwd) {
				 b = userDAO.insertUser(userDTO);
			}
			//System.out.println(b);
			String page =b?"login.jsp": "regist.jsp";
			String tipeStr =b?"<label style='color:green'>ע��ɹ������¼��</label>":"<label style='color:red'>ע��ʧ�ܣ�����������ע����Ϣ</label>";
			if(b) {
				request.setAttribute("userName", userName);
			}
			request.setAttribute("tips", tipeStr);
			request.getRequestDispatcher(page).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
