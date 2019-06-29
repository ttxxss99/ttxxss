package cn.edu.whpu.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.whpu.music.dto.MusicListDTO;
import cn.edu.whpu.music.utils.DBManager;

public class MusicListDAO {
	
	
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
	public boolean insertMusiclist(MusicListDTO musiclist) {
		boolean b = false;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "insert into tb_musiclists(list_name,list_desc,list_time,list_uid) values(?,?,?,?)";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setString(1, musiclist.getListName());
			pStatement.setString(2, musiclist.getListDesc());
			pStatement.setString(3, musiclist.getListTime());
			pStatement.setInt(4, musiclist.getListUid());
			//5.ִ��SQL
			int i = pStatement.executeUpdate();
			//6.������
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		
		return b;
		
	}
	/**
	 * �����û�idɾ��һ���û���Ϣ
	 * @param uid ��Ҫɾ�����û�id
	 * @return	���ɾ���ɹ�����true��ʧ���򷵻�false
	 */
	public boolean deleteMusiclist(int lid) {
		boolean b = false;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "delete from tb_musiclists where list_id=?";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setInt(1, lid);
			//5.ִ��SQL
			int i = pStatement.executeUpdate();
			//6.������
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
	/**
	 * �����û�id�޸�������Ϣ
	 * @param user ������Ҫ�޸ĵ��û�id�������ֶ�ֵ
	 * @return	����޸ĳɹ�����true��ʧ���򷵻�false
	 */
	public boolean updateMusiclist(MusicListDTO musiclist) {
		boolean b = false;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "updata tb_musiclists set list_name=?,list_desc=?,list_time=?,list_uid=? where list_id=?";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setString(1, musiclist.getListName());
			pStatement.setString(2, musiclist.getListDesc());
			pStatement.setString(3, musiclist.getListTime());
			pStatement.setInt(4, musiclist.getListUid());
			pStatement.setInt(5, musiclist.getListId());
			//5.ִ��SQL
			int i = pStatement.executeUpdate();
			//6.������
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
	/**
	 * �����û�id��ѯһ���û���Ϣ
	 * @param uid ��Ҫ��ѯ���û�id
	 * @return	��ѯ�����û���Ϣ�����û�в�ѯ���û���Ϣ���򷵻�null
	 */
	public List<MusicListDTO> queryMusiclistById(int lid) {
		List<MusicListDTO> musiclistDTOs = new ArrayList<MusicListDTO>();
		MusicListDTO musiclist = null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "select * from tb_musiclists where list_uid=?";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setInt(1, lid);
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
			while(resultSet.next()) {
				int listId = resultSet.getInt("list_id");
				String listName = resultSet.getString("list_name");
				String listDesc = resultSet.getString("list_desc");
				String listTime = resultSet.getString("list_time");
				int  listUid = resultSet.getInt("list_uid");
				musiclist = new MusicListDTO(listId, listName, listDesc, listTime, listUid);
				musiclistDTOs.add(musiclist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		System.out.println(musiclistDTOs.size());
		return musiclistDTOs;
	}
	/**
	 * ��ѯ�����û���Ϣ
	 * @return	������������û�����
	 */
	public List<MusicListDTO> listMusicLists(){
		List<MusicListDTO> musiclistDTOs = new ArrayList<MusicListDTO>();
		MusicListDTO musiclist=null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "select * from tb_musiclists ";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
			while(resultSet.next()) {
				musiclist.setListId(resultSet.getInt("list_id"));
				musiclist.setListName(resultSet.getString("list_name"));
				musiclist.setListDesc(resultSet.getString("list_desc"));
				musiclist.setListTime(resultSet.getString("list_time"));
				musiclist.setListUid(resultSet.getInt("list_uid"));
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
