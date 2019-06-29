package cn.edu.whpu.music.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.whpu.music.dto.MusicDTO;
import cn.edu.whpu.music.utils.DBManager;

public class MusicDAO {
	
	
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
//	public boolean insertMusic(MusicDTO music) {
//		boolean b = false;
//		try {
//			//1.创建连接
//			connection =  DBManager.getConn();
//			//2.准备SQL指令
//			String sql = "insert into tb_musics(music_name,music_art,music_album,music_path) values(?,?,?,?)";
//			//3.价值SQL
//			pStatement = connection.prepareStatement(sql);
//			//4.给SQL中的？赋值
//			pStatement.setString(1, music.getMusicName());
//			pStatement.setString(2, music.getMusicArt());
//			pStatement.setString(3, music.getMusicAlbum());
//			pStatement.setString(4, music.getMusicPath());
//			//5.执行SQL
//			int i = pStatement.executeUpdate();
//			//6.处理结果
//			b = i>0?true:false;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(null, pStatement, connection);
//		}
//		
//		return b;
//		
//	}
//	/**
//	 * 根据用户id删除一条用户信息
//	 * @param uid 需要删除的用户id
//	 * @return	如果删除成功返回true，失败则返回false
//	 */
//	public boolean deleteMusic(int mid) {
//		boolean b = false;
//		try {
//			//1.创建连接
//			connection =  DBManager.getConn();
//			//2.准备SQL指令
//			String sql = "delete from tb_musics where music_id=?";
//			//3.价值SQL
//			pStatement = connection.prepareStatement(sql);
//			//4.给SQL中的？赋值
//			pStatement.setInt(1, mid);
//			//5.执行SQL
//			int i = pStatement.executeUpdate();
//			//6.处理结果
//			b = i>0?true:false;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(null, pStatement, connection);
//		}
//		return b;
//	}
//	/**
//	 * 根据用户id修改其他信息
//	 * @param user 包含需要修改的用户id和其他字段值
//	 * @return	如果修改成功返回true，失败则返回false
//	 */
//	public boolean updateMusic(MusicDTO music) {
//		boolean b = false;
//		try {
//			//1.创建连接
//			connection =  DBManager.getConn();
//			//2.准备SQL指令
//			String sql = "updata tb_musics set music_name=?,music_art=?,music_album=?,music_path=? where music_id=?";
//			//3.价值SQL
//			pStatement = connection.prepareStatement(sql);
//			//4.给SQL中的？赋值
//			pStatement.setString(1, music.getMusicName());
//			pStatement.setString(2, music.getMusicArt());
//			pStatement.setString(3, music.getMusicAlbum());
//			pStatement.setString(4, music.getMusicPath());
//			pStatement.setInt(5, music.getMusicId());
//			//5.执行SQL
//			int i = pStatement.executeUpdate();
//			//6.处理结果
//			b = i>0?true:false;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(null, pStatement, connection);
//		}
//		return b;
//	}
//	/**
//	 * 根据用户id查询一个用户信息
//	 * @param uid 需要查询的用户id
//	 * @return	查询到的用户信息，如果没有查询到用户信息，则返回null
//	 */
	public MusicDTO queryMusicById(int mid) {
		MusicDTO music = null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令*
			String sql = "select * from tb_musics where music_id=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setInt(1, mid);
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
			if(resultSet.next()) {
				int musicId = resultSet.getInt("music_id");
				String musicName = 	resultSet.getString("music_name");
				String musicArt = resultSet.getString("music_art");
				String musicAlbum = resultSet.getString("music_album");
				String musicPath = resultSet.getString("music_path");
				music = new MusicDTO(musicId, musicName, musicArt, musicAlbum, musicPath);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return music;
	}
//	/**
//	 * 查询所有用户信息
//	 * @return	包含多个所用用户集合
//	 */
	
	public List<MusicDTO> searchMusics(String kw){
		List<MusicDTO> musicDTOs = new ArrayList<MusicDTO>();
		MusicDTO music=null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			String kkw = "%"+kw+"%";
			//2.准备SQL指令
			String sql = "select * from tb_musics where music_name like ? or music_art like ? ";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,kkw);
			pStatement.setString(2,kkw);
			//4.给SQL中的？赋
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
			while(resultSet.next()) {
			int musicId = resultSet.getInt("music_id");
			String musicName = 	resultSet.getString("music_name");
			String musicArt = resultSet.getString("music_art");
			String musicAlbum = resultSet.getString("music_album");
			String musicPath = resultSet.getString("music_path");
			music = new MusicDTO(musicId, musicName, musicArt, musicAlbum, musicPath);
			musicDTOs.add(music);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return musicDTOs;
		
	}
	public List<MusicDTO> listMusics(){
		List<MusicDTO> musicDTOs = new ArrayList<MusicDTO>();
		MusicDTO music=null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select * from tb_musics ";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
			while(resultSet.next()) {
			int musicId = resultSet.getInt("music_id");
			String musicName = 	resultSet.getString("music_name");
			String musicArt = resultSet.getString("music_art");
			String musicAlbum = resultSet.getString("music_album");
			String musicPath = resultSet.getString("music_path");
			music = new MusicDTO(musicId, musicName, musicArt, musicAlbum, musicPath);
			musicDTOs.add(music);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return musicDTOs;
	}
	
	
	
}
