package com.fm.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.backend.dao.CondolenceDao;
import com.fm.backend.dto.Condolence;
import com.fm.backend.dto.ResultData;
import com.fm.backend.util.Util;

@Service
public class CondolenceService {	
	
	@Autowired
	private CondolenceDao condolenceDao;

	public List<Condolence> getForPrintCondolences(int boardId) {	
		return condolenceDao.getForPrintCondolences(boardId);
	}

	public ResultData addCondolence(Map<String, Object> param) {
		condolenceDao.addCondolence(param);

		int id = Util.getAsInt(param.get("id"), 0);

		return new ResultData("S-1", "조의문 작성 완료.", "id", id);
	}

	public ResultData getCondolenceById(int id) {
		
		Condolence condolence = condolenceDao.getCondolenceById(id);
		
		return new ResultData("S-1", "조의문 불러오기 완료.", "condolence", condolence);
	}

	public ResultData modifyCondolence(Integer id, String writer, String body) {
		
		condolenceDao.modifyCondolence(id, writer, body);
		
		return new ResultData("S-1", "조의문 수정 완료.", "id", id);
	}

	public ResultData deleteCondolence(Integer id) {
		condolenceDao.deleteCondolence(id);
		
		return new ResultData("S-1", "조의문 삭제 완료.", "id", id);
	}	

}
