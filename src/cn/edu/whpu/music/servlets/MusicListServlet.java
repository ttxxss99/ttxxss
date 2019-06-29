package cn.edu.whpu.music.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.whpu.music.dao.MusicDAO;
import cn.edu.whpu.music.dto.MusicDTO;
//µ„ª˜±æµÿ“Ù¿÷
@WebServlet("/MusicListServlet")
public class MusicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MusicDAO mDao = new MusicDAO();
		List<MusicDTO> musiclist = mDao.listMusics();
		MusicDTO mDto = musiclist.get(0);
		//System.out.println(mDto.getMusicAlbum());
		request.setAttribute("key3", musiclist);
		request.getRequestDispatcher("myMusic.jsp").forward(request, response);
	}

}
