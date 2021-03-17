package com.fm.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.backend.dto.Condolence;
import com.fm.backend.dto.ResultData;
import com.fm.backend.service.CondolenceService;

@Controller
public class UsrCondolenceController extends BaseController{
	
	@Autowired
	CondolenceService condolenceService;

	@GetMapping("/usr/condolence/list")
	@ResponseBody
	public ResultData shwoList(@RequestParam(defaultValue = "1") int boardId, String searchKeywordType, String searchKeyword, @RequestParam(defaultValue = "1") int page) {
		
		List<Condolence> condolences = condolenceService.getForPrintCondolences(boardId);
		
		for(Condolence condolence : condolences) {
			String reduceRegDate = condolence.getRegDate().substring(0,10);
			
			condolence.setRegDate(reduceRegDate);
		}
		
		return new ResultData("S-1", "조의문 불러오기 완료", "condolences", condolences);
	}
	
}
