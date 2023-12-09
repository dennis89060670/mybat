package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.porder;

@Mapper //產生Bean
public interface porderMapper {
	//create
	@Insert("insert into porder(name,a,b,c) name=#{name},a=#{a},b=#{b},c=#{c}")
	void add(porder p);
	
	//Select
	@Select("select * from porder")
	List<porder> queryall();
}
