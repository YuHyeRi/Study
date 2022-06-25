package com.oracle.study_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class abcController {
	
	// 화면을 띄워주는 컨트롤러
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String abc() {
		
		return "abc";	// abc view를 리턴한다
	}
	
	// ajax 통신을 할 컨트롤러 (ajax이니까 @ResponseBody 必)
	@RequestMapping(value = "/abcAjax", method = RequestMethod.GET)
	@ResponseBody
	public String abcAjax() {
		
		String str = "abc";
		
		return str;		// 변수 str을 리턴한다.
	}
	

}
