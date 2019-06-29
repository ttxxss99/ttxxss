package cn.edu.whpu.music.dto;

public class MusicDTO {
	private int musicId;
	private String musicName;
	private String musicArt;
	private String musicAlbum;
	private String musicPath;
	public MusicDTO() {
		super();
	}
	public MusicDTO(int musicId, String musicName, String musicArt, String musicAlbum, String musicPath) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.musicArt = musicArt;
		this.musicAlbum = musicAlbum;
		this.musicPath = musicPath;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicArt() {
		return musicArt;
	}
	public void setMusicArt(String musicArt) {
		this.musicArt = musicArt;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public String getMusicPath() {
		return musicPath;
	}
	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	
	
	
}
