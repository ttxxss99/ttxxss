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
//			//1.��������
//			connection =  DBManager.getConn();
//			//2.׼��SQLָ��
//			String sql = "insert into tb_musics(music_name,music_art,music_album,music_path) values(?,?,?,?)";
//			//3.��ֵSQL
//			pStatement = connection.prepareStatement(sql);
//			//4.��SQL�еģ���ֵ
//			pStatement.setString(1, music.getMusicName());
//			pStatement.setString(2, music.getMusicArt());
//			pStatement.setString(3, music.getMusicAlbum());
//			pStatement.setString(4, music.getMusicPath());
//			//5.ִ��SQL
//			int i = pStatement.executeUpdate();
//			//6.������
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
//	 * �����û�idɾ��һ���û���Ϣ
//	 * @param uid ��Ҫɾ�����û�id
//	 * @return	���ɾ���ɹ�����true��ʧ���򷵻�false
//	 */
//	public boolean deleteMusic(int mid) {
//		boolean b = false;
//		try {
//			//1.��������
//			connection =  DBManager.getConn();
//			//2.׼��SQLָ��
//			String sql = "delete from tb_musics where music_id=?";
//			//3.��ֵSQL
//			pStatement = connection.prepareStatement(sql);
//			//4.��SQL�еģ���ֵ
//			pStatement.setInt(1, mid);
//			//5.ִ��SQL
//			int i = pStatement.executeUpdate();
//			//6.������
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
//	 * �����û�id�޸�������Ϣ
//	 * @param user ������Ҫ�޸ĵ��û�id�������ֶ�ֵ
//	 * @return	����޸ĳɹ�����true��ʧ���򷵻�false
//	 */
//	public boolean updateMusic(MusicDTO music) {
//		boolean b = false;
//		try {
//			//1.��������
//			connection =  DBManager.getConn();
//			//2.׼��SQLָ��
//			String sql = "updata tb_musics set music_name=?,music_art=?,music_album=?,music_path=? where music_id=?";
//			//3.��ֵSQL
//			pStatement = connection.prepareStatement(sql);
//			//4.��SQL�еģ���ֵ
//			pStatement.setString(1, music.getMusicName());
//			pStatement.setString(2, music.getMusicArt());
//			pStatement.setString(3, music.getMusicAlbum());
//			pStatement.setString(4, music.getMusicPath());
//			pStatement.setInt(5, music.getMusicId());
//			//5.ִ��SQL
//			int i = pStatement.executeUpdate();
//			//6.������
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
//	 * �����û�id��ѯһ���û���Ϣ
//	 * @param uid ��Ҫ��ѯ���û�id
//	 * @return	��ѯ�����û���Ϣ�����û�в�ѯ���û���Ϣ���򷵻�null
//	 */
	public MusicDTO queryMusicById(int mid) {
		MusicDTO music = null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��*
			String sql = "select * from tb_musics where music_id=?";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setInt(1, mid);
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
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
//	 * ��ѯ�����û���Ϣ
//	 * @return	������������û�����
//	 */
	
	public List<MusicDTO> searchMusics(String kw){
		List<MusicDTO> musicDTOs = new ArrayList<MusicDTO>();
		MusicDTO music=null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			String kkw = "%"+kw+"%";
			//2.׼��SQLָ��
			String sql = "select * from tb_musics where music_name like ? or music_art like ? ";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,kkw);
			pStatement.setString(2,kkw);
			//4.��SQL�еģ���
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
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
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "select * from tb_musics ";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
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
