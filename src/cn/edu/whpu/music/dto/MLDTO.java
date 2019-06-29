package cn.edu.whpu.music.dto;

public class MLDTO {
	private int lId;
	private int mId;
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public MLDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MLDTO(int lId, int mId) {
		super();
		this.lId = lId;
		this.mId = mId;
	}
	
}
