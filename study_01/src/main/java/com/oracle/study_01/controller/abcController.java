package com.oracle.study_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.study_01.dto.TestDto;
import com.oracle.study_01.mapper.TestMapper;

@Controller
public class abcController {

	@Autowired
	TestMapper testMapper;

	// 화면 띄워주는 controller
	@RequestMapping(value = "/abc", method = RequestMethod.GET)	// 요청하는 방식은 get
	public String abc() {
		
		return "abc"; // abc view를 리턴한다 (application.properties에 spring.thymeleaf.prefix(suffix) 설정해두었기때문)
	}

	// ajax 통신을 할 컨트롤러 (ajax이니까 @ResponseBody 必)
	@RequestMapping(value = "/abcAjax", method = RequestMethod.GET)
	@ResponseBody 		// 응답을 할 때 그 내용을 body에 담아서 한다.
	public List<TestDto> abcAjax() throws Exception {
		List<TestDto> list = testMapper.testSelectAll();
		
		return list; // 변수 str을 리턴한다.
	}
	
	// tbody클릭시 comment 띄워주는 ajax 통신 컨트롤러
	@RequestMapping(value = "/commAjax", method = RequestMethod.GET)
	@ResponseBody
	public String commAjax(TestDto testDto) throws Exception {
		
		String comment = testMapper.CommList(testDto);
		
		System.out.println("comment ============>" + comment);
		
		return comment;
	}

	
}
