package com.example.food_map.constants;

public enum RtnCode {
	
	SUCCESSFUL("200" , "���榨�\!!"),
	CANNOT_EMPTY("400","�A��J���F��O�Ū�!!"),
	DATA_ERROR("400","��J��Ʀ��~�Э��s��J!!"),
	ALREADY_EXIST("400","�A��J���F��w�g�s�b!!"),
	NOT_FOUND("404","�䤣��A��J���F��!!"),
	EXCEED("400","�w�g�W�L�i�H��J���ƶq�F!!");
	
	private String code;
	
	private String message;

	
	
	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
