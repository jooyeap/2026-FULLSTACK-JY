package com.the703.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserKakao implements UserInfoOAuth2{
	
	private final Map<String, Object> attributes;	
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getKakaoAccount(){
		Object kakaoAccount = attributes.get("kakao_account");
		return kakaoAccount instanceof Map
				? (Map<String, Object>)kakaoAccount : null;
	}
	
	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getProviderId() {
		Object id = attributes.get("id");
		return id != null ? id.toString() : null;
	}

	@Override
	public String getEmail() {
		Map<String, Object> kakaoAccount = getKakaoAccount();
		return kakaoAccount != null ?
				String.valueOf( kakaoAccount.get("email") ) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getNickname() {
		Map<String, Object> kakaoAccount = getKakaoAccount();
		Object profile = kakaoAccount.get("profile");
		Map<String, Object> nickname = (Map<String, Object>)profile; 
		return nickname != null ? String.valueOf( nickname.get("nickname") ) : null;
	}

	@Override
	public String getImage() {
		return null;
	}

}

////////// 1) 기본뼈대작성
////////// 2) 예외상황에 대한 방어코드로 개선코드 보여줘
