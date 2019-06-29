package cn.edu.whpu.music.dto;

/**
 * DTO�����ڴ���JDBC���������ݣ�
 * DTO�ഴ���淶��
 * 	1.DTO�������Եĸ���������Ҫ���Ӧ���������ݱ��е��ֶα���һ��
 * 	2.�ṩ�޲ι�����
 * 	3.�ṩ�������в����Ĺ�����
 * 	4.�ṩ���е����Ե�get��set����
 * @author asus
 *
 */
public class UserDTO {
	
	
	
	private int userId;
	private String userName;
	private String userPwd;
	private String userNick;
	private String userSex;
	private String userPic;
	private String userDesc;
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserSex() {
		return userSex;
	}


	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}


	public String getUserPic() {
		return userPic;
	}


	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}


	public String getUserDesc() {
		return userDesc;
	}


	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}



	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDTO( int userId, String userName, String userPwd, String userNick, String userSex, String userPic,
			String userDesc) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userNick = userNick;
		this.userSex = userSex;
		this.userPic = userPic;
		this.userDesc = userDesc;
	}
	public UserDTO(  String userName, String userPwd, String userNick, String userSex, String userPic,
			String userDesc) {
		super();
	//	this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userNick = userNick;
		this.userSex = userSex;
		this.userPic = userPic;
		this.userDesc = userDesc;
	}
	
	
	
}
