package com.fm.backend.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
	
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String main() {
		return "확인";
	}

}
