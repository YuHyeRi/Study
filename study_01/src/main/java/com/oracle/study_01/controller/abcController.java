package com.oracle.study_01.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.study_01.mapper.TestMapper;

@Controller
public class abcController {
	
	@Autowired
	TestMapper testMapper;
	
	// 화면을 띄워주는 컨트롤러
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String abc() {

		return "abc";	// abc view를 리턴한다
	}
	
	// ajax 통신을 할 컨트롤러 (ajax이니까 @ResponseBody 必)
	@RequestMapping(value = "/abcAjax", method = RequestMethod.GET)
	@ResponseBody
	public List<String> abcAjax() {
		
		List<String> str = testMapper.testSelect();
		
		return str;		// 변수 str을 리턴한다.
	}
	

}
