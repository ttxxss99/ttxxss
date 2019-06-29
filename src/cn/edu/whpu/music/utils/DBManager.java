package cn.edu.whpu.music.utils;

import java.sql.*;;

/**
 * ���ڹ������ݿ����ӣ��������ӣ��ر�����
 * @author asus
 *
 */
public class DBManager {
	/*1.�����ݿ���������jar�ļ����뵽��ǰ��Ŀ��
	 *   a.��jar�ļ���������Ŀ��webContent/WEB-INF/lib�ļ���
	 *   b.*ѡ��jar������*/
	/*2.׼�����ݿ�������Ϣ*/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_music";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	/**
	 * 3.�ھ�̬����ͨ������������ݿ�����
	 */
	static {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * �������ݿ�����
	 * @return ���ݿ�����
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
