package com.example.demo.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.membermapper;
import com.example.demo.serivce.impl.memberSeviceImpl;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpSession;

@RestController
public class memberController {
	@Autowired
	memberSeviceImpl msi;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/login")
	public ModelAndView gotologin(String username,String password)
	{

		member m=msi.Login(username,password);//為什麼msi連到Login的功能
		ModelAndView mav=null;
		
		if(m!=null)
		{
			session.setAttribute("M", m);
			mav=new ModelAndView("/loginsuccess");		
		}else {
			mav=new ModelAndView("/loginerror");
		}
		
		return mav;
	}
	
	@GetMapping("/addmember")//post傳資料
	public ModelAndView gotoaddmember()
	{
		return new ModelAndView("/addmember");
	}
	
	@PostMapping("/add")
	public ModelAndView add(String name,String username,String password)
	{
		/*
		 * 1.檢查 username是否重複
		 * 2.沒有就新增
		 */
		
		boolean u=msi.UsernameRepeat(username);//檢查 username是否重複
		ModelAndView mav=null;
		if(u)
		{
			mav=new ModelAndView("addmembersuccess");
		}else {
			member m=new member(name,username,password);
			mav=new ModelAndView("addmembererror");
		}
		
		return mav;
	}

}
