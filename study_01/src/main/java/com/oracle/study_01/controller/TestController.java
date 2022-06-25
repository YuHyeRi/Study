package com.oracle.study_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//모든 컨트롤러에 responseBody가 붙음
//@RestController 

@Controller
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testController(Model model) {
		System.out.println("testController start");
		String test = "바보입니다.";

		return "test";
	}
	
	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	@ResponseBody
	public String ajaxController(Model model) {
		System.out.println("ajaxController start");
		
		String ajaxResult = "바보입니다.";

		return ajaxResult;
	}

}
