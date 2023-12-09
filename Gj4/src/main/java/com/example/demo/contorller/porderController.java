package com.example.demo.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.serivce.porderService;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/porder")
public class porderController {
	@Autowired
	porderService pS;
	@Autowired
	HttpSession session;
	
	@PostMapping("add")
	public ModelAndView add(int a,int b,int c)
	{
		/*
		 * 1.擷取　session-->member
		 * 2.new porder-->轉session
		 * 3.換頁-->confirm.html
		 */
		
		member m=(member) session.getAttribute("M");
		porder p=new porder(m.getName(),a,b,c);//把m的資料丟到p裡面
		//ModelAndView mav=null;
		session.setAttribute("P",p);//set要接收所以要小寫p去丟資料 前面porder new p;
		return new ModelAndView("porder/confirm");
	}
	
	//Get為切換頁面 post為新增資料
	@GetMapping("porder")
	public ModelAndView gotoPorder()
	{
		return new ModelAndView("porder/porder"); 
	}
	
	@PostMapping("finish")
	public ModelAndView gotofinish()
	{
		return new ModelAndView("porder/finish");
	}
	
	
}
