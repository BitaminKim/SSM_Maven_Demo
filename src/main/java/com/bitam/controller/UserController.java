package com.bitam.controller;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	IUserService iUserService;
	
	@RequestMapping(value = "insertUser", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertUser(User user) throws Exception {
		System.out.println(user.getUsername());
		int count = iUserService.insertUser(user);
		return "add"+count;
		
	}
	
	@RequestMapping(value = "deleteUserById", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteUserById(int id) {
		return "delete"+iUserService.deleteUserById(id);
	}
	
	@RequestMapping(value = "updateUser", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateUser(User user) {
		return "update"+iUserService.updateUser(user);
	}
	
	@RequestMapping(value = "selectUserCount", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserCount(HttpServletResponse response) {
		return "database sum("+iUserService.selectUserCount()+")";
	}
	
	@RequestMapping(value = "selectUserAll", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserAll(HttpServletResponse response) {
		List<User> list = iUserService.selectUserAll();
		StringBuilder sb = new StringBuilder();
		String ln = "\r\n";
		String str;
		sb.append("<!DOCTYPE html>"+ln);
		sb.append("<html lang=\"zh_cn\">"+ln);
		sb.append("<head><meta charset=\"utf-8\" /></head>"+ln);
		sb.append("<body>"+ln);
		sb.append("<table align='center' border='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>username</td><td>password</td><td>age</td><td>sex</td></tr>"+ln);
		String formatstr = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>\t\n";	
		for(User user : list) {
			str = String.format(formatstr, user.getId(),user.getUsername(),user.getPassword(),user.getAge(),user.getSex());
			sb.append(str);
		}
		sb.append("</table>"+ln);
		sb.append("<h1>BitaminKim 增删改查SSM Demo</h1>"+ln);
		sb.append("</body>"+ln);
		sb.append("</html>");
		return sb.toString();
				
	}
	
	@RequestMapping(value = "selectUserById", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserById(int id) {
		User user = iUserService.selectUserById(id);
		StringBuilder sb = new StringBuilder();
		String ln = "\r\n";
		String str;
		sb.append("<!DOCTYPE html>"+ln);
		sb.append("<html lang=\"zh_cn\">"+ln);
		sb.append("<head><meta charset=\"utf-8\" /></head>"+ln);
		sb.append("<body>"+ln);
		sb.append("<table align='center' border='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>username</td><td>password</td><td>age</td><td>sex</td></tr>"+ln);
		String formatstr = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>\t\n";	
		str = String.format(formatstr, user.getId(),user.getUsername(),user.getPassword(),user.getAge(),user.getSex());
		sb.append(str);
		sb.append("</table>");
		sb.append("</body>"+ln);
		sb.append("</html>");
		return sb.toString();
	}
	
	
	
	
}
