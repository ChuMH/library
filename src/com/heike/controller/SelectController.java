package com.heike.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.SelectService;


@Controller
@RequestMapping("/select")
public class SelectController {

	@Resource
	private SelectService selectservice;

	@RequestMapping("/showAllT")
	public String showTeacher(Model m, String pageNo, HttpSession session) {
		int pagesize = 8;
		int currentPage = 1;
		int totalDateCount = 0;
		int totalPageCount = 0;
		totalDateCount = selectservice.getTotalTeacherCount();
		m.addAttribute("totalDateCount", totalDateCount);
		if (totalDateCount % pagesize == 0)
			totalPageCount = totalDateCount / pagesize;
		else
			totalPageCount = totalDateCount / pagesize + 1;
		m.addAttribute("totalPageCount", totalPageCount);
		session.setAttribute("tpc", totalPageCount);
		if (pageNo != null)
			currentPage = Integer.parseInt(pageNo);
		if (currentPage > totalPageCount)
			currentPage = totalPageCount;
		if (currentPage < 1)
			currentPage = 1;
		m.addAttribute("currentPage", currentPage);
		Map map = new HashMap();
		map.put("startlocation", (currentPage - 1) * pagesize);
		map.put("length", pagesize);
		m.addAttribute("tList", selectservice.selectAllTeacher(map));
		return "mteacher";
	}
	
	@RequestMapping("/showAllS")
	public String showStudents(Model m, String pageNo, HttpSession session) {
		int pagesize = 8;
		int currentPage = 1;
		int totalDateCount = 0;
		int totalPageCount = 0;
		totalDateCount = selectservice.getTotalStudentCount();
		m.addAttribute("totalDateCount", totalDateCount);
		if (totalDateCount % pagesize == 0)
			totalPageCount = totalDateCount / pagesize;
		else
			totalPageCount = totalDateCount / pagesize + 1;
		m.addAttribute("totalPageCount", totalPageCount);
		session.setAttribute("tpc", totalPageCount);
		if (pageNo != null)
			currentPage = Integer.parseInt(pageNo);
		if (currentPage > totalPageCount)
			currentPage = totalPageCount;
		if (currentPage < 1)
			currentPage = 1;
		m.addAttribute("currentPage", currentPage);
		Map map = new HashMap();
		map.put("startlocation2", (currentPage - 1) * pagesize);
		map.put("length2", pagesize);
		m.addAttribute("sList", selectservice.selectAllStudents(map));
		//System.out.println(selectservice.selectAllStudents(map));
		return "mstudent";
	}
	//��ʾָ������ѧ��
	@RequestMapping("/showHS")
	public String showHouseStudents(Model m, String pageNo, HttpSession session) {
		Teacher t = (Teacher)session.getAttribute("user");
		System.out.println(t);
		int pagesize = 8;
		int currentPage = 1;
		int totalDateCount = 0;
		int totalPageCount = 0;
		totalDateCount = selectservice.getHstudentCount(t.getT_houseid());
		m.addAttribute("totalDateCount2", totalDateCount);
		if (totalDateCount % pagesize == 0)
			totalPageCount = totalDateCount / pagesize;
		else
			totalPageCount = totalDateCount / pagesize + 1;
		m.addAttribute("totalPageCount2", totalPageCount);
		session.setAttribute("tpc2", totalPageCount);
		if (pageNo != null)
			currentPage = Integer.parseInt(pageNo);
		if (currentPage > totalPageCount)
			currentPage = totalPageCount;
		if (currentPage < 1)
			currentPage = 1;
		m.addAttribute("currentPage2", currentPage);
		Map map = new HashMap();
		map.put("startlocation2", (currentPage - 1) * pagesize);
		map.put("length2", pagesize);
		map.put("houseid", t.getT_houseid());
		m.addAttribute("sList", selectservice.selectHStudents(map));
		//System.out.println(selectservice.selectAllStudents(map));
		return "mHstudent";
	}
	@RequestMapping("/showBadS")
	public String showBStudents(Model m,String pageNo,  HttpSession session) {
		int pagesize = 8;
		int currentPage = 1;
		int totalDateCount = 0;
		int totalPageCount = 0;
		totalDateCount = selectservice.getBadStudentCount();
		m.addAttribute("totalDateCount", totalDateCount);
		if (totalDateCount % pagesize == 0)
			totalPageCount = totalDateCount / pagesize;
		else
			totalPageCount = totalDateCount / pagesize + 1;
		m.addAttribute("totalPageCount", totalPageCount);
		session.setAttribute("tpc", totalPageCount);
		if (pageNo != null)
			currentPage = Integer.parseInt(pageNo);
		if (currentPage > totalPageCount)
			currentPage = totalPageCount;
		if (currentPage < 1)
			currentPage = 1;
		m.addAttribute("currentPage", currentPage);
		Map map = new HashMap();
		map.put("startlocation3", (currentPage - 1) * pagesize);
		map.put("length3", pagesize);
		m.addAttribute("bList", selectservice.selectBadStudents(map));
		//System.out.println(selectservice.selectBadStudents(map));
		return "mstudent2";
	}
	@RequestMapping("/showAllTask")
	public String showAllTask(HttpSession session,Model m,String pageNo) {
		int pagesize = 8;
		int currentPage = 1;
		int totalDateCount = 0;
		int totalPageCount = 0;
		//totalDateCount = selectservice.getTotalStudentCount();
		totalDateCount = selectservice.getTotalTask(((Students)session.getAttribute("user")).getStu_id());
		m.addAttribute("totalDateCount", totalDateCount);
		if (totalDateCount % pagesize == 0)
			totalPageCount = totalDateCount / pagesize;
		else
			totalPageCount = totalDateCount / pagesize + 1;
		m.addAttribute("totalPageCount", totalPageCount);
		session.setAttribute("tpc", totalPageCount);
		if (pageNo != null)
			currentPage = Integer.parseInt(pageNo);
		if (currentPage > totalPageCount)
			currentPage = totalPageCount;
		if (currentPage < 1)
			currentPage = 1;
		m.addAttribute("currentPage", currentPage);
		Map map = new HashMap();
		map.put("sid", ((Students)session.getAttribute("user")).getStu_id());
		map.put("startlocation", (currentPage - 1) * pagesize);
		map.put("length", pagesize);
		m.addAttribute("taskList", selectservice.selectAllTask(map));
		return "seetask";
	}
	@RequestMapping("/showAllH")
	public String showAllH(Model m, HttpSession session) {
		 m.addAttribute("hList",selectservice.showAllH());
		return "house";
	}
/*	@RequestMapping("/showMyS")
	public String showMyS(Model m, HttpSession session) {
		 session.getAttribute("user");
		
		m.addAttribute("mList",selectservice.showMyS(null));
		return "xueyuan";
	}*/
	@RequestMapping("/searchT")
	public String searchT(Model m, HttpSession session,Integer search) {
		m.addAttribute("t1",selectservice.searchT(search));
		return "showsearchT";
	}
	@RequestMapping("/searchS")
	public String searchS(Model m, HttpSession session,String search) {
		//System.out.println(search);
		//m.addAttribute("s1",selectservice.searchS(search));
		Map map = new HashMap<>();
		map.put("search", search);
		List list = selectservice.searchS(map);
		m.addAttribute("slist", list);
		/*Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		return "showsearchS";
	}
}
