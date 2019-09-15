package com.heike.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.services.DeleteService;


@Controller
@RequestMapping("/delete")
public class DeleteController {
	@Resource
	private DeleteService delservice;
	
	@RequestMapping("/delH")
	public String deleteHouse(Integer house_id) {
		delservice.deleteH(house_id);
		return "redirect:/select/showAllH.do";
	}
	
	@RequestMapping("/delT")
	public String deleteTeacher(Integer t_id) {
		delservice.deleteT(t_id);
		return "redirect:/select/showAllT.do";
	}
	@RequestMapping("/delS")
	public String deleteStudent(Integer stu_id) {
		delservice.deleteS(stu_id);
		return "redirect:/select/showAllS.do";
	}
	@RequestMapping("/refuseS")
	public String refuseStudent(Integer s_id) {
		delservice.refuseS(s_id);
		return "redirect:/select/showBadS.do";
	}
	@RequestMapping("/delTask")
	public String deleteTask(Integer task_id) {
		delservice.deleteTask(task_id);
		return "redirect:/select/showAllTask";
	}
}
