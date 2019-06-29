package cn.edu.whpu.music.utils;

import java.sql.*;;

/**
 * 用于管理数据库连接：创建连接，关闭连接
 * @author asus
 *
 */
public class DBManager {
	/*1.将数据库连接驱动jar文件导入到当前项目中
	 *   a.将jar文件拷贝到项目的webContent/WEB-INF/lib文件夹
	 *   b.*选择jar包导入*/
	/*2.准备数据库连接信息*/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_music";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	/**
	 * 3.在静态快中通过反射加载数据库驱动
	 */
	static {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 创建数据库连接
	 * @return 数据库连接
	 */
	
	public static Connection getConn() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return connection;
	}
	/**
	 * 
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
