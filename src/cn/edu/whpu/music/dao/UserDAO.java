package cn.edu.whpu.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.edu.whpu.music.dto.UserDTO;
import cn.edu.whpu.music.utils.DBManager;

/**
 * 此类用于完成对tb_users表的数据库操作
 * @author asus
 *
 */
public class UserDAO {
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
	
	
	/**
	 * 添加用户信息
	 * @param user 需要添加到数据库的用户信息
	 * @return	如果添加成功返回true，失败则返回false
	 */
	public boolean insertUser(UserDTO user) {
		boolean b = false;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "insert into tb_users(user_name,user_pwd,user_nick,user_sex,user_pic,user_desc) values(?,?,?,?,?,?)";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPwd());
			pStatement.setString(3, user.getUserNick());
			pStatement.setString(4, user.getUserSex());
			pStatement.setString(5, user.getUserPic());
			pStatement.setString(6, user.getUserDesc());
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
//	public boolean deleteUser(int uid) {
//		boolean b = false;
//		try {
//			//1.创建连接
//			connection =  DBManager.getConn();
//			//2.准备SQL指令
//			String sql = "delete from tb_users where user_id=?";
//			//3.价值SQL
//			pStatement = connection.prepareStatement(sql);
//			//4.给SQL中的？赋值
//			pStatement.setInt(1, uid);
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
//	public boolean updateUser(UserDTO user) {
//		boolean b = false;
//		try {
//			//1.创建连接
//			connection =  DBManager.getConn();
//			//2.准备SQL指令
//			String sql = "updata tb_users set user_name=?,user_pwd=?,user_nick=?,user_sex=?,user_pic=?,user_desc=? where user_id=?";
//			//3.价值SQL
//			pStatement = connection.prepareStatement(sql);
//			//4.给SQL中的？赋值
//			pStatement.setString(1, user.getUserName());
//			pStatement.setString(2, user.getUserPwd());
//			pStatement.setString(3, user.getUserNick());
//			pStatement.setString(4, user.getUserSex());
//			pStatement.setString(5, user.getUserPic());
//			pStatement.setString(6, user.getUserDesc());
//			pStatement.setInt(7, user.getUserId());
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
	/**
	 * 根据用户名和密码查询一个用户信息
	 * @param 输入的密码和用户名
	 * @return	查询到的用户信息，如果没有查询到用户信息，则返回null
	 */
	public UserDTO queryUserById(String name,String pwd) {
		UserDTO user = null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select * from tb_users where user_name=? and user_pwd=?";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋值
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			//6.处理结果
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
	 * 查询所有用户信息
	 * @return	包含多个所用用户集合
	 */
	public List<UserDTO> listUsers(){
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserDTO user=null;
		try {
			//1.创建连接
			connection =  DBManager.getConn();
			//2.准备SQL指令
			String sql = "select from tb_users ";
			//3.价值SQL
			pStatement = connection.prepareStatement(sql);
			//4.给SQL中的？赋
			//5.执行SQL
			resultSet = pStatement.executeQuery();
			
			//6.处理结果
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
			//1.创建连接
			connection  = DBManager.getConn();
			//2.准备sql指令
			String sql = "select * from tb_users where user_id = ? ";
			//3.加载sql
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
			//1.创建连接
			connection  = DBManager.getConn();
			//2.准备sql指令
			String sql = "select * from tb_users where user_name =? and user_pwd =?";
			//3.加载sql
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,name);
			pStatement.setString(2,pwd);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				
				//取到一个用户的值
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
			//1.创建连接
			connection  = DBManager.getConn();
			//2.准备sql指令
			String sql = "update tb_users set user_name  =?,user_pwd =?,user_nick=?,user_sex =?,user_pic =?,user_desc=? where user_id =? ";
			//3.加载sql
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPwd());
			pStatement.setString(3, user.getUserNick());
			pStatement.setString(4, user.getUserSex());
			pStatement.setString(5, user.getUserPic());
			pStatement.setString(6, user.getUserDesc());
			pStatement.setInt(7,user.getUserId());
			//5.执行结果
			int i = pStatement.executeUpdate();
			//6.处理结果
			b = i>0?true:false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pStatement, connection);
		}
		return b;
	}
}
