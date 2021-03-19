package com.fm.backend.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResultData shwoList(@RequestParam(defaultValue = "1") int boardId, @RequestParam(defaultValue = "1") int page) {
		
		List<Condolence> condolences = condolenceService.getForPrintCondolences(boardId);
		
		for(int i = condolences.size() - 4; i >= 0; i--) {
			condolences.remove(i);
		}
		
		for(Condolence condolence : condolences) {
			String reduceRegDate = condolence.getRegDate();
			reduceRegDate = reduceRegDate.substring(2, 16).replace(" ", " | ");
			
			condolence.setRegDate(reduceRegDate);
			
			if(condolence.getBody().length() > 15) {
				String reduceBody = condolence.getBody();
				condolence.setBody(reduceBody.substring(0, 14) + "...");
			}
		}
		
		Collections.reverse(condolences);
		
		return new ResultData("S-1", "조의문 불러오기 완료", "condolences", condolences);
	}
	
	@RequestMapping("/usr/condolence/doAdd")
	@ResponseBody
	public ResultData doAdd(@RequestParam Map<String, Object> param, HttpServletRequest req) {
		if (param.get("writer") == null) {
			return new ResultData("F-1", "작성자를 입력해주세요.");
		}
		
		if (param.get("password") == null) {
			return new ResultData("F-1", "비밀번호를 입력해주세요.");
		}
		
		if (param.get("body") == null) {
			return new ResultData("F-1", "조의문을 입력해주세요.");
		}

		return condolenceService.addCondolence(param);
	}

	
	@RequestMapping("/usr/condolence/showCondolence")
	@ResponseBody
	public ResultData showCondolence(@RequestParam("id") int id, HttpServletRequest req) {		
		if(id == 0) {
			return new ResultData("F-1", "존재하지 않는 조의문 번호입니다.", "id", id);
		}
		
		return condolenceService.getCondolenceById(id);
	}
	
	
}
