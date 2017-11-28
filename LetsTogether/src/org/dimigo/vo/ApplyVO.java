package org.dimigo.vo;

public class ApplyVO {
	private String getapplyid;
	private String doapplyid;
	private int pk;
	
	@Override
	public String toString() {
		return "ApplyVO [getapplyid=" + getapplyid + ", doapplyid=" + doapplyid + ", pk=" + pk + "]";
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

}
