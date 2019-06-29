package cn.edu.whpu.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.edu.whpu.music.dto.UserDTO;
import cn.edu.whpu.music.utils.DBManager;

/**
 * ����������ɶ�tb_users������ݿ����
 * @author asus
 *
 */
public class UserDAO {
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
	
	
	/**
	 * ����û���Ϣ
	 * @param user ��Ҫ��ӵ����ݿ���û���Ϣ
	 * @return	�����ӳɹ�����true��ʧ���򷵻�false
	 */
	public boolean insertUser(UserDTO user) {
		boolean b = false;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "insert into tb_users(user_name,user_pwd,user_nick,user_sex,user_pic,user_desc) values(?,?,?,?,?,?)";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPwd());
			pStatement.setString(3, user.getUserNick());
			pStatement.setString(4, user.getUserSex());
			pStatement.setString(5, user.getUserPic());
			pStatement.setString(6, user.getUserDesc());
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
//	public boolean deleteUser(int uid) {
//		boolean b = false;
//		try {
//			//1.��������
//			connection =  DBManager.getConn();
//			//2.׼��SQLָ��
//			String sql = "delete from tb_users where user_id=?";
//			//3.��ֵSQL
//			pStatement = connection.prepareStatement(sql);
//			//4.��SQL�еģ���ֵ
//			pStatement.setInt(1, uid);
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
//	public boolean updateUser(UserDTO user) {
//		boolean b = false;
//		try {
//			//1.��������
//			connection =  DBManager.getConn();
//			//2.׼��SQLָ��
//			String sql = "updata tb_users set user_name=?,user_pwd=?,user_nick=?,user_sex=?,user_pic=?,user_desc=? where user_id=?";
//			//3.��ֵSQL
//			pStatement = connection.prepareStatement(sql);
//			//4.��SQL�еģ���ֵ
//			pStatement.setString(1, user.getUserName());
//			pStatement.setString(2, user.getUserPwd());
//			pStatement.setString(3, user.getUserNick());
//			pStatement.setString(4, user.getUserSex());
//			pStatement.setString(5, user.getUserPic());
//			pStatement.setString(6, user.getUserDesc());
//			pStatement.setInt(7, user.getUserId());
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
	/**
	 * �����û����������ѯһ���û���Ϣ
	 * @param �����������û���
	 * @return	��ѯ�����û���Ϣ�����û�в�ѯ���û���Ϣ���򷵻�null
	 */
	public UserDTO queryUserById(String name,String pwd) {
		UserDTO user = null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "select * from tb_users where user_name=? and user_pwd=?";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���ֵ
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			//6.������
			//System.out.println("sss");
			while(resultSet.next()) {
				int  userID = resultSet.getInt("user_id");
				String userName =  resultSet.getString("user_name");
				String userPwd =  resultSet.getString("user_pwd");
				String userNick =  resultSet.getString("user_nick");
				String userSex =  resultSet.getString("user_sex");
				String userPic =  resultSet.getString("user_pic");
				String userDesc = resultSet.getString("user_desc");
//				user.setUserId(resultSet.getInt("user_id"));
//				user.setUserName(resultSet.getString("user_name"));
//				user.setUserPwd(resultSet.getString("user_pwd"));
//				user.setUserNick(resultSet.getString("user_nick"));
//				user.setUserSex(resultSet.getString("user_sex"));
//				user.setUserPic(resultSet.getString("user_pic"));
//				user.setUserDesc(resultSet.getString("user_desc"));
				user = new UserDTO(userID,userName, userPwd, userNick, userSex, userPic, userDesc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return user;
	}
	/**
	 * ��ѯ�����û���Ϣ
	 * @return	������������û�����
	 */
	public List<UserDTO> listUsers(){
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserDTO user=null;
		try {
			//1.��������
			connection =  DBManager.getConn();
			//2.׼��SQLָ��
			String sql = "select from tb_users ";
			//3.��ֵSQL
			pStatement = connection.prepareStatement(sql);
			//4.��SQL�еģ���
			//5.ִ��SQL
			resultSet = pStatement.executeQuery();
			
			//6.������
			while(resultSet.next()) {
			//	user.setUserId(resultSet.getInt("user_id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setUserPwd(resultSet.getString("user_pwd"));
				user.setUserNick(resultSet.getString("user_nick"));
				user.setUserSex(resultSet.getString("user_sex"));
				user.setUserPic(resultSet.getString("user_pic"));
				user.setUserDesc(resultSet.getString("user_desc"));
				userDTOs.add(user);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return userDTOs;
	}
	
	public UserDTO queryUserById(int uid) {
		UserDTO user = null;
		try {
			//1.��������
			connection  = DBManager.getConn();
			//2.׼��sqlָ��
			String sql = "select * from tb_users where user_id = ? ";
			//3.����sql
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1,uid);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				int userID = resultSet.getInt("user_id");
				String userName =resultSet.getString("user_name");
				String userNick =resultSet.getString("user_nick");
				String userPic =resultSet.getString("user_pic");
				String userPwd =resultSet.getString("user_pwd");
				String userSex =resultSet.getString("user_sex");
				String userDesc = resultSet.getString("user_desc");
			user = new UserDTO(userID, userName, userPwd, userNick, userSex, userPic, userDesc);

			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return user;
	}
	
	public UserDTO checkLogin(String name, String pwd) {
		UserDTO user = null;
		
		try {
			//1.��������
			connection  = DBManager.getConn();
			//2.׼��sqlָ��
			String sql = "select * from tb_users where user_name =? and user_pwd =?";
			//3.����sql
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,name);
			pStatement.setString(2,pwd);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				
				//ȡ��һ���û���ֵ
					int userId = resultSet.getInt("user_id");
					String userName =resultSet.getString("user_name");
					String userNick =resultSet.getString("user_nick");
					String userPic =resultSet.getString("user_pic");
					String userPwd =resultSet.getString("user_pwd");
					String userSex =resultSet.getString("user_sex");
					String userDesc = resultSet.getString("user_desc");
				user = new UserDTO(userId, userName, userPwd, userNick, userSex, userPic, userDesc);

				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(resultSet, pStatement, connection);
		}
		return user;
	}
	
	public boolean updateUser(UserDTO  user) {
		boolean b = false;
		try {
			//1.��������
			connection  = DBManager.getConn();
			//2.׼��sqlָ��
			String sql = "update tb_users set user_name  =?,user_pwd =?,user_nick=?,user_sex =?,user_pic =?,user_desc=? where user_id =? ";
			//3.����sql
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPwd());
			pStatement.setString(3, user.getUserNick());
			pStatement.setString(4, user.getUserSex());
			pStatement.setString(5, user.getUserPic());
			pStatement.setString(6, user.getUserDesc());
			pStatement.setInt(7,user.getUserId());
			//5.ִ�н��
			int i = pStatement.executeUpdate();
			//6.������
			b = i>0?true:false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
}
