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
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "insert into tb_musiclists(list_name,list_desc,list_time,list_uid) values(?,?,?,?)";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setString(1, musiclist.getListName());
			pStatement.setString(2, musiclist.getListDesc());
			pStatement.setString(3, musiclist.getListTime());
			pStatement.setInt(4, musiclist.getListUid());
			//5.执行SQL
			int i = pStatement.executeUpdate();
			//6.处理结果
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		
		return b;
		
	}
	/**
	 * 根据用户id删除一条用户信息
	 * @param uid 需要删除的用户id
	 * @return	如果删除成功返回true，失败则返回false
	 */
	public boolean deleteMusiclist(int lid) {
		boolean b = false;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "delete from tb_musiclists where list_id=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setInt(1, lid);
			//5.执行SQL
			int i = pStatement.executeUpdate();
			//6.处理结果
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
	/**
	 * 根据用户id修改其他信息
	 * @param user 包含需要修改的用户id和其他字段值
	 * @return	如果修改成功返回true，失败则返回false
	 */
	public boolean updateMusiclist(MusicListDTO musiclist) {
		boolean b = false;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "updata tb_musiclists set list_name=?,list_desc=?,list_time=?,list_uid=? where list_id=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setString(1, musiclist.getListName());
			pStatement.setString(2, musiclist.getListDesc());
			pStatement.setString(3, musiclist.getListTime());
			pStatement.setInt(4, musiclist.getListUid());
			pStatement.setInt(5, musiclist.getListId());
			//5.执行SQL
			int i = pStatement.executeUpdate();
			//6.处理结果
			b = i>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
	/**
	 * 根据用户id查询一个用户信息
	 * @param uid 需要查询的用户id
	 * @return	查询到的用户信息，如果没有查询到用户信息，则返回null
	 */
	public List<MusicListDTO> queryMusiclistById(int lid) {
		List<MusicListDTO> musiclistDTOs = new ArrayList<MusicListDTO>();
		MusicListDTO musiclist = null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select * from tb_musiclists where list_uid=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setInt(1, lid);
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
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
	 * 查询所有用户信息
	 * @return	包含多个所用用户集合
	 */
	public List<MusicListDTO> listMusicLists(){
		List<MusicListDTO> musiclistDTOs = new ArrayList<MusicListDTO>();
		MusicListDTO musiclist=null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select * from tb_musiclists ";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
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
