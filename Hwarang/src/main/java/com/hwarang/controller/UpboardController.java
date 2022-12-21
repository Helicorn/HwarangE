package com.hwarang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hwarang.vo.UpboardVo;

@Controller
public class UpboardController {
	
	@RequestMapping("/upboard_list")
	public ModelAndView upboard_list(HttpServletRequest request, @ModelAttribute UpboardVo upvo) {
		ModelAndView listM=new ModelAndView();
		listM.setViewName("");
		return listM;
	}
}
