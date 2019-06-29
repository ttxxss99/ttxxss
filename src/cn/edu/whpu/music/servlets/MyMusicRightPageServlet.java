package cn.edu.whpu.music.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.whpu.music.dao.MLDAO;
import cn.edu.whpu.music.dao.MusicDAO;
import cn.edu.whpu.music.dto.MLDTO;
import cn.edu.whpu.music.dto.MusicDTO;
import javafx.geometry.Pos;

@WebServlet("/MyMusicRightPageServlet")
public class MyMusicRightPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String string = request.getParameter("id");
		//	System.out.println("asd");
			int lid = Integer.parseInt(string);
			//int lid = 1;
			MLDAO mldao = new MLDAO();
			List<MLDTO> mldtos = mldao.queryMusiclistById(lid);
			MusicDAO musicDAO = new MusicDAO();
			List<MusicDTO> musicDTOs = new ArrayList<MusicDTO>();
			MusicDTO musicDTO = null;
			//List<MLDTO> mldtos = mldao.queryMusiclistById(lid);
				for(int i=0;i<mldtos.size();i++) {
					musicDTO = musicDAO.queryMusicById(mldtos.get(i).getmId());
					musicDTOs.add(musicDTO);
				}
				//System.out.println(musicDTOs.size());
			request.setAttribute("key3", musicDTOs);
			request.getRequestDispatcher("right.jsp").forward(request, response);
	}

}
