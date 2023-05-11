package com.example.food_map.constants;

public enum RtnCode {
	
	SUCCESSFUL("200" , "執行成功!!"),
	CANNOT_EMPTY("400","你輸入的東西是空的!!"),
	DATA_ERROR("400","輸入資料有誤請重新輸入!!"),
	ALREADY_EXIST("400","你輸入的東西已經存在!!"),
	NOT_FOUND("404","找不到你輸入的東西!!"),
	EXCEED("400","已經超過可以輸入的數量了!!");
	
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
