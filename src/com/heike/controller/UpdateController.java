package com.heike.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.SelectService;
import com.heike.services.UpdateService;


@Controller
@RequestMapping("/update")
public class UpdateController {
	@Resource
	private UpdateService updates;
	@Resource
	private SelectService selects;
		@RequestMapping("/jupdateT")
		public String jumpToUpdateT(Integer t_id,Model m,HttpSession session) {
			session.setAttribute("tid", t_id);
			List<House> list = selects.selectH();
			m.addAttribute("teacher", selects.selectTById(t_id));
			m.addAttribute("houseList", list);
			return "updateteacher";
		}
			@RequestMapping("/jupdateS")
			public String jumpToUpdateS(Integer stu_id,Model m,HttpSession session) {
				session.setAttribute("sid", stu_id);
				List<House> list = selects.selectH();
				m.addAttribute("stu", selects.selectSById(stu_id));
				m.addAttribute("houseList", list);
				return "updatestu";
			}
			@RequestMapping("/jupdateH")
			public String jumpToUpdateH(Integer house_id,Model m,HttpSession session) {
				session.setAttribute("hid", house_id);
				m.addAttribute("house", selects.selectHById(house_id));
				return "updatehouse";
			}
			
			@RequestMapping("/updateT")
			public String updateTeacher(Teacher t,HttpSession session) {
				t.setT_id((Integer)session.getAttribute("tid"));
				updates.updateT(t);
				return "redirect:/select/showAllT.do";
			}
			
			@RequestMapping("/updateS")
			public String updateStudent(Students stu,HttpSession session) {
				stu.setStu_id((Integer)session.getAttribute("sid"));
				updates.updateS(stu);
				return "redirect:/select/showAllS.do";
			}
			@RequestMapping("/updateH")
			public String updateHouse(House house,HttpSession session) {
				house.setHouse_id((Integer)session.getAttribute("hid"));
				updates.updateH(house);
				return "redirect:/select/showAllH.do";
			}
			@RequestMapping("/agreeS")
			public String agreeStudent(Integer s_id) {
				updates.updateAudit(s_id);
				return "redirect:/select/showBadS.do";
			}
}
