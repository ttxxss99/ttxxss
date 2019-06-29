package cn.edu.whpu.music.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.whpu.music.dao.MusicListDAO;
import cn.edu.whpu.music.dto.MusicListDTO;
import cn.edu.whpu.music.dto.UserDTO;

@WebServlet("/MyMusicLiftPageServlet")
public class MyMusicLiftPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		String  str = request.getParameter("id");
//		int i = Integer.parseInt(str);
		UserDTO user=(UserDTO)request.getSession().getAttribute("user");
		MusicListDAO musicListDAO = new MusicListDAO();
	//	System.out.println(i);
		List<MusicListDTO> musicList = musicListDAO.queryMusiclistById(user.getUserId());
	//	
		System.out.println(musicList.size());
		request.setAttribute("musicList",musicList);
		request.getRequestDispatcher("double.jsp").forward(request, response);
	//	System.out.println(user.getUserName());
		
	}

}
