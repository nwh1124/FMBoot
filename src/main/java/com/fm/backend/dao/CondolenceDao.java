package com.fm.backend.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.fm.backend.dto.Condolence;
import com.fm.backend.dto.ResultData;

@Mapper
public interface CondolenceDao {

	public List<Condolence> getForPrintCondolences(int boardId);
	public void addCondolence(Map<String, Object> param);
	public Condolence getCondolenceById(int id);

}
