package org.dimigo.vo;

public class ApplyVO {
	private String getapplyid;
	private String doapplyid;
	private int pk;
	
	private int result;
	private String title;
	private String post;

	@Override
	public String toString() {
		return "ApplyVO [getapplyid=" + getapplyid + ", doapplyid=" + doapplyid + ", pk=" + pk + ", result=" + result
				+ ", title=" + title + ", post=" + post + "]";
	}
	
	public String getGetapplyid() {
		return getapplyid;
	}
	public void setGetapplyid(String getapplyid) {
		this.getapplyid = getapplyid;
	}
	public String getDoapplyid() {
		return doapplyid;
	}
	public void setDoapplyid(String doapplyid) {
		this.doapplyid = doapplyid;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}


}
