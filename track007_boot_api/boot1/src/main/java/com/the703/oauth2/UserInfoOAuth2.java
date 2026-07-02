package com.the703.oauth2;


public interface UserInfoOAuth2 {
	
	public String getProvider();
	public String getProviderId();
	public String getEmail();
	public String getNickname();
	public String getImage();
	
}
