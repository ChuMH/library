package com.heike.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.InsertService;
import com.heike.services.SelectService;


@Controller
@RequestMapping("/insert")
public class InsertController {
	@Resource
	private InsertService inserts;
	@Resource
	private SelectService selectservice;
	@RequestMapping("/jtoAReg")
	public String jumpToAdminReg() {
		return "adminReg";
	}
	
	@RequestMapping("/jaddT")
	public String jumpToAddT(Model m)  {
		List<House> list = selectservice.selectH();
		m.addAttribute("houseList", list);
		return "addteacher";
	}
	
		/*@RequestMapping("/jaddT2")
		public String jumpToAddT2(Model m,byte[] b) throws UnsupportedEncodingException  {
			for(byte b2 : b) {
				System.out.print(b2+" ");
			}
			
			List<House> list = selectservice.selectH();
			m.addAttribute("houseList", list);
			
			return "addteacher";
		}*/

		@RequestMapping("/jaddS")
		public String jumpToAddS(Model m) {
			List<House> list = selectservice.selectH();
			m.addAttribute("houseList", list);
			return "addstu";
		}
	
		@RequestMapping("/jaddH")
		public String jumpToAddH(Model m) {
			return "addhouse";
		}
	
	@RequestMapping("/addA")
	public String insertAdmin(Admin admin,Model m) {
		List<Admin> list = selectservice.selectAdmin();
		Iterator it = list.iterator();
		while(it.hasNext()) {
		if((((Admin)it.next()).getAdmin_username()).equals(admin.getAdmin_username())) {
			m.addAttribute("err", "该用户名已存在");
			return "adminReg";
		}
		}
		inserts.insertAdmin(admin);
		return "blank";
	}
	@RequestMapping("/addT")
	public String insertTeacher(Teacher t,Model m,HttpSession session){
		List<Teacher> list = selectservice.selectTeacher();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Teacher tea = (Teacher)it.next();
		if(tea.getT_username().equals(t.getT_username())) {
			List<House> hlist = selectservice.selectH();
			m.addAttribute("houseList", hlist);
			m.addAttribute("err", "该用户名已存在");
			return "addteacher";
		}
		}
		inserts.insertT(t);
		return "redirect:/select/showAllT.do";
	}
	@RequestMapping("/addS")
	public String insertStudent(Students s,Model m) {
		List<Students> list= selectservice.selectStudent();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Students stu = (Students)it.next();
			if(stu.getStu_username().equals(s.getStu_username())) {
				List<House> hlist = selectservice.selectH();
				m.addAttribute("houseList", hlist);
				m.addAttribute("err","该用户名已存在");
				return "addstu";
			}else if(stu.getStu_no()==s.getStu_no()) {
				List<House> hlist = selectservice.selectH();
				m.addAttribute("houseList", hlist);
				m.addAttribute("err","该学号已存在");
				return "addstu";
			}
		}
		inserts.insertS(s);
		return "redirect:/select/showAllS.do";
	}
	@RequestMapping("/addH")
	public String insertHouse(House h) {
		inserts.insertH(h);
		return "redirect:/select/showAllH.do";
	}
	@RequestMapping("/jwords")
	public String jumpWords() {
		
		return "leavewords";
	}
	@RequestMapping("/jtaskS")
	public String jumpTask(Integer stu_id,HttpSession session) {
		session.setAttribute("hsid", stu_id);
		return "task";
	}
	@RequestMapping("addtask")
	public String addTask(String information,HttpSession session) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String task_time=sdf.format(date);
		Map map = new HashMap();
		map.put("tid", ((Teacher)session.getAttribute("user")).getT_id());
		map.put("info", information);
		map.put("task_time", task_time);
		map.put("sid", session.getAttribute("hsid"));
		inserts.addtask(map);
		return "redirect:/select/showHS.do";
	}
	@RequestMapping("/jupload")
	public String jumpU(Integer stu_id,HttpSession session) {
		System.out.println(stu_id+"----------------============---------------");
		session.setAttribute("stu_id", stu_id);
		return "audit";
	}
	@RequestMapping("/upload")
	public String upload1(String username,MultipartFile img,HttpServletRequest request,HttpSession session) {
		Integer stu_id = (Integer)session.getAttribute("stu_id");
		boolean b2 = new File("D:/image").mkdir();
		//request有一个方法能够获取到服务器的路径
		String path = "D:/image/";//服务器的对象
		String filename=img.getOriginalFilename();
		int index = filename.lastIndexOf(".");
		String houzhui=filename.substring(index, filename.length());
		String rFilename = 	System.currentTimeMillis()+"-"+houzhui;
		//System.out.println(filename);
		InputStream io= null;
		FileOutputStream fileout = null;
	
		try {
			io = img.getInputStream();
			String str = path+rFilename;
			Map map = new HashMap();
			map.put("stu_id", stu_id);
			map.put("photo_address", str);
			inserts.addAudit(map);
			fileout = new FileOutputStream(str);
			int i = 0;
			byte[] b = new byte[1024];
			while((i=io.read(b))!=-1) {
				fileout.write(b,0,i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				io.close();
				fileout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload";
	}
}
