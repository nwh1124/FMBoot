package com.fm.backend.dto;

import java.util.Map;

import com.fm.backend.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//생성자 자동 생성
@NoArgsConstructor
@AllArgsConstructor
public class ResultData {
	
	private String resultCode;
	private String msg;
	private Map<String, Object> body;
	
	public ResultData(String resultCode, String msg, Object... args) {		
		this.resultCode = resultCode;
		this.msg = msg;
		this.body = Util.mapOf(args);		
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}

}
