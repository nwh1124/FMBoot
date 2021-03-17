package com.fm.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.backend.dao.CondolenceDao;
import com.fm.backend.dto.Condolence;

@Service
public class CondolenceService {	
	
	@Autowired
	private CondolenceDao condolenceDao;

	public List<Condolence> getForPrintCondolences(int boardId) {	
		return condolenceDao.getForPrintCondolences(boardId);
	}	

}
