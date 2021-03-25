package com.fm.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.backend.dto.ResultData;
import com.fm.backend.util.Util;
import com.fm.backend.util.dto.api.Aligo__send__ResponseBody;

@Controller
public class UsrHomeController extends BaseController{	

	@GetMapping("/usr/home/doSendSms")
	@ResponseBody
	public ResultData doSendSms(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("msg") String msg) {		
		Aligo__send__ResponseBody rb = Util.sendSms(from, to, msg);

		return new ResultData("S-1", "발송되었습니다.", "from", from, "to", to, "msg", msg, "rb", rb);
	}
	
}
