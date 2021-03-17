package com.fm.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Condolence {
	
	int id;
	String regDate;
	String updateDate;
	String body;
	@JsonIgnore
	String password;
	int boardId;	
	String writer;

}
