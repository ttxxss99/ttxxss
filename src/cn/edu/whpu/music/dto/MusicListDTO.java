package cn.edu.whpu.music.dto;

public class MusicListDTO {
	private int listId;
	private String listName;
	private String listDesc;
	private String listTime;
	private int listUid;
	
	
	
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getListDesc() {
		return listDesc;
	}
	public void setListDesc(String listDesc) {
		this.listDesc = listDesc;
	}
	public String getListTime() {
		return listTime;
	}
	public void setListTime(String listTime) {
		this.listTime = listTime;
	}
	public int getListUid() {
		return listUid;
	}
	public void setListUid(int listUid) {
		this.listUid = listUid;
	}
	public MusicListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicListDTO(int listId, String listName, String listDesc, String listTime, int listUid) {
		super();
		this.listId = listId;
		this.listName = listName;
		this.listDesc = listDesc;
		this.listTime = listTime;
		this.listUid = listUid;
	}
	
	
}
