package com.emaillist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emaillist.repository.EmaillistDao;
import com.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired private EmaillistDao dao;

	@RequestMapping("/form")
	public String form(@ModelAttribute EmaillistVo vo) {
		System.out.println(vo.toString());
		
		
		
		return "/form";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute EmaillistVo vo) {
		System.out.println(vo.toString());
		dao.insert(vo);
		
		
		return "redirect:/list";//끊어서 읽어내는
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<EmaillistVo> list =dao.getList();
		System.out.println(list.toString());
		model.addAttribute("list",list);
		return "/list";
		
	}
	@RequestMapping("/test")
	public void test() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("lastName", "김");
		map.put("email", "kimggigik@naver.com");
		List<EmaillistVo> list=dao.getByMap(map);
		System.out.println(list.toString());
		
		
		
		
		/*EmaillistVo vo=dao.getByteNo(82);
		System.out.println("getByteNo()");
		System.out.println(vo.toString());*/
		
		
	}
	
	
}
