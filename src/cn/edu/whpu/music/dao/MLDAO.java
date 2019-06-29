package cn.edu.whpu.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.whpu.music.dto.MLDTO;
import cn.edu.whpu.music.utils.DBManager;

public class MLDAO {
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
	public List<MLDTO> queryMusiclistById(int lid) {
		List<MLDTO> musiclistDTOs = new ArrayList<MLDTO>();
		MLDTO musiclist = null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select * from tb_list_music where lid=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setInt(1, lid);
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
			while(resultSet.next()) {
				int listId = resultSet.getInt("lid");
				int  MusicId = resultSet.getInt("mid");
				musiclist = new MLDTO(listId, MusicId);
				musiclistDTOs.add(musiclist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return musiclistDTOs;
	}
}
