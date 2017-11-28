package org.dimigo.vo;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String intro = " ";
	private String etc = " ";

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", intro=" + intro + ", etc=" + etc + "]";
	}

	public UserVO() {
		
	};
	
	public UserVO(String id, String pwd, String name, String nickname, String intro, String etc) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.intro = intro;
		this.etc = etc;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

}
