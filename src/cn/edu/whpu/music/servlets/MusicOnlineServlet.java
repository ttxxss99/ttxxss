package cn.edu.whpu.music.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bm.http.client.HTTPClientUtil;

//在线音乐
@WebServlet("/MusicOnlineServlet")
public class MusicOnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受搜索关键词
		
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("kw");
		
		//2.向云音乐服务器发送请求
		String url = "http://music.163.com/api/search/get";
		HashMap params = new HashMap();
		params.put("s",str);
		params.put("limit", 15);
		params.put("type", 1);
		String v = HTTPClientUtil.doPost(url, params);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(v);
		out.flush();
		out.close();
		
	}

}
