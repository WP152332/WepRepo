package org.dimigo.vo;

public class PostVO {
	private String id;
	private String posting;
	private String title;
	private String date;
	private int pk;
	
	@Override
	public String toString() {
		return "PostVO [id=" + id + ", posting=" + posting + ", title=" + title + ", date= " + date + ", pk=" + pk + "]";
	}

	public PostVO() {
		
	};
	
	public PostVO(String id, String posting, String title, String nicktitle, String date, int pk) {
		this.id = id;
		this.posting = posting;
		this.title = title;
		this.date = date;
		this.pk = pk;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosting() {
		return posting;
	}
	public void setPosting(String posting) {
		this.posting = posting;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
}
