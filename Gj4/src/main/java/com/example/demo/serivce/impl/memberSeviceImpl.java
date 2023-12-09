package com.example.demo.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.membermapper;
import com.example.demo.serivce.memberService;
import com.example.demo.vo.member;

@Service//轉換成Bean物件
public class memberSeviceImpl implements memberService{
	@Autowired
	membermapper mm;
	
	@Override
	public void addMember(member m) {
		mm.add();	
	}
	
	@Override
	public member Login(String username, String password) {
		member m=mm.querymember(username, password);
		
		return m;
	}

	@Override
	public boolean UsernameRepeat(String username) {
		member m=mm.queryusername(username);
		boolean x=false;
		if(m!=null) x=true;
		
		return x;
	}
}
