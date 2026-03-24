package com.skynetidc.dto;

public class AuthResponse {

	private String email;

	private String name;

	private String image;

	private String accessToken;

	public AuthResponse(String email, String name, String image, String accessToken) {
		this.email = email;
		this.name = name;
		this.image = image;
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
