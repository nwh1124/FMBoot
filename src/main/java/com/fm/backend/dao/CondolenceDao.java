package com.fm.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fm.backend.dto.Condolence;

@Mapper
public interface CondolenceDao {

	public List<Condolence> getForPrintCondolences(int boardId);

}
