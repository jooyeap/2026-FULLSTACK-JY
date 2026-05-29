package com.the703.board01_mvc1;

import java.util.Objects;

public class UserDto {
	private int uno;
	private String nickname;
	private String bpass;
	private String email;
	private String mobile;
	private String udate;
	private String bip;
	
	public UserDto(String nickname, String bpass, String email, String mobile, String udate, String bip) {
		super();
		this.nickname = nickname;
		this.bpass = bpass;
		this.email = email;
		this.mobile = mobile;
		this.udate = udate;
		this.bip = bip;
	}
	public UserDto() { super(); }
	public int getUno() { return uno; }
	public void setUno(int uno) { this.uno = uno; }
	public String getNickname() { return nickname; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public String getBpass() { return bpass; }
	public void setBpass(String bpass) { this.bpass = bpass; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getMobile() { return mobile; }
	public void setMobile(String mobile) { this.mobile = mobile; }
	public String getUdate() { return udate; }
	public void setUdate(String udate) { this.udate = udate; }
	public String getBip() { return bip; }
	public void setBip(String bip) { this.bip = bip; }
	@Override
	public String toString() {
		return "UserDto [uno=" + uno + ", nickname=" + nickname + ", bpass=" + bpass + ", email=" + email + ", mobile="
				+ mobile + ", udate=" + udate + ", bip=" + bip + "]";
	}
	@Override public int hashCode() { return Objects.hash(bip, bpass, email, mobile, nickname, udate, uno); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(bip, other.bip) && Objects.equals(bpass, other.bpass)
				&& Objects.equals(email, other.email) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(nickname, other.nickname) && Objects.equals(udate, other.udate) && uno == other.uno;
	} 
	
	
}
