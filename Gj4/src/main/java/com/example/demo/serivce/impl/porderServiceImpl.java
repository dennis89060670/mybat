package com.example.demo.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.porderMapper;
import com.example.demo.serivce.porderService;
import com.example.demo.vo.porder;

@Service
public class porderServiceImpl implements porderService{
	@Autowired
	porderMapper pM;
	
	@Override
	public void addPorder(porder p)
	{
		pM.add(p);
	}
	
	@Override
	public List<porder> findAll()
	{
		return findAll();
	}
}
