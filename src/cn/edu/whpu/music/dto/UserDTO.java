package cn.edu.whpu.music.dto;

/**
 * DTO类用于传输JDBC操作的数据：
 * DTO类创建规范：
 * 	1.DTO类中属性的个数和类型要与对应操作的数据表中的字段保持一致
 * 	2.提供无参构造器
 * 	3.提供带有所有参数的构造器
 * 	4.提供所有的属性的get和set方法
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
