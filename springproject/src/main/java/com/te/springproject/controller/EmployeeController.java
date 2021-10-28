package com.te.springproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springproject.dto.Employee;
import com.te.springproject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@InitBinder
	public void init(WebDataBinder binder) {
		CustomDateEditor customDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, customDateEditor);
	}

	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String authenticate(ModelMap map, int user, String pwd, HttpServletRequest request) {
		Employee employee = employeeService.authenticate(user, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", employee);
		if (employee != null) {
			map.addAttribute("details", employee);
			return "welcome";
		} else {
			map.addAttribute("msg", "no data found");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg1", "Logout successful");
		return "login";
	}

	@GetMapping("/search")
	public String search(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		if (employee != null) {
			return "search";
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@PostMapping("/search")
	public String searchMain(int user, ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		Employee employee2 = employeeService.find(user);
		map.addAttribute("emp", employee2);
		if (employee != null) {
			if (employee2 != null) {
				return "search";
			} else {
				map.addAttribute("msg2", "no data found for this id");
				return "search";
			}
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@GetMapping("/add")
	public String add(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map) {
		if (employee != null) {
			return "add";
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@PostMapping("/add")
	public String addMain(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map,
			Employee employee2) {
		if (employee != null) {
			if (employeeService.add(employee2)) {
				map.addAttribute("msg", "data added");
				return "add";
			} else {
				map.addAttribute("msg", "something went wrong");
				return "add";
			}
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@GetMapping("/delete")
	public String delete(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map) {
		if (employee != null) {
			return "delete";
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@PostMapping("/delete")
	public String deleteMain(int id, @SessionAttribute(name = "loggedIn") Employee employee, ModelMap map) {
		if (employee != null) {
			if (employeeService.delete(id)) {
				map.addAttribute("msg", "successfully deleted");
				return "delete";
			} else {
				map.addAttribute("msg2", "id not matching please enter valid id");
				return "delete";
			}
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@GetMapping("/findall")
	public String findAll(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map) {
		List<Employee> employees = employeeService.findAll();
		if (employee != null) {
			if (employees != null) {
				map.addAttribute("employees", employees);
				return "findall";
			} else {
				map.addAttribute("msg", "something went wrong");
				return "welcome";
			}
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}

	@GetMapping("/update")
	public String update(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map) {
		if (employee != null) {
			return "update";
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}
@PostMapping("/update")
	public String updateMain(@SessionAttribute(name = "loggedIn", required = false) Employee employee, ModelMap map) {
		if (employee != null) {
			if (employeeService.update(employee)) {
				map.addAttribute("msg", "update succcessful");
				return "update";
			} else {
				map.addAttribute("msg", "something went wrong");
				return "update";
			}
		} else {
			map.addAttribute("msg", "please login again");
			return "login";
		}
	}
}
