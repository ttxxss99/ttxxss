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
			 	
				//接受数据 【文件上传】
					SmartUpload su = new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					//设置文件格式
					su.setAllowedFilesList("jpg,png,bmp");
					//设置文件大小
					su.setMaxFileSize(2*1024*1024);
					su.upload();
					//从su中取出文本信息和文本
					
					//获取文件
					Files fs =  su.getFiles();
					//用于存储用户上传的头像在项目中的相对路径
					String userPhoto ="photos/";
					//遍历
					
					if(fs.getCount()>0) {
						File f =fs.getFile(0);
						//文件后缀名
						String fileName = new Date().getTime() +"."+f.getFileExt();
						System.out.println(fileName);
						
						userPhoto  =userPhoto + fileName;
						//获取项目中photos目录在服务器中的路径
						String  path = getServletContext().getRealPath("photos").toString();
						//文件的绝对路径
						f.saveAs(path+"/"+fileName);
					
					//从su中取出文本信息
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
					//根据保存结果进行跳转
						String page = b?"index.jsp":"edit.jsp";
						String tipeStr =b?"<label style = 'color:green'>注册成功，请登录！</label>":"<label style = 'color:red'>注册失败，请重新输入！</label>";
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
