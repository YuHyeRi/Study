package com.oracle.study_01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oracle.study_01.dto.TestDto;

@Mapper
public interface TestMapper {

	public List<String> testSelect(); 		// testSelect와 mapper.xml의 id를 매칭

	public List<TestDto> testSelectAll();	// testSelectAll와 mapper.xml의 id를 매칭

}
