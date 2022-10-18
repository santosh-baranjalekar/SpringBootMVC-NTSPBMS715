package com.nt.controller;

import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/") // To show the home page
	public String showHome() {
		return "home";
	}

	@GetMapping("/emp_report")
	public String showEmployeesReport(Map<String, Object> map) {
		System.out.println("EmployeeOperationsController.showEmployeesReport()");
		// use service
		Iterable<Employee> itEmps = empService.getAllEmployees();
		// put result in model attributes
		map.put("empList", itEmps);
		// return LVN
		return "show_employee_report";
	}

	@GetMapping("/emp_add") // for form launching
	public String saveEmployee(@ModelAttribute("emp") Employee emp) {
		// return LVN
		return "register_employee";
	}

	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		// use service
		String msg = empService.registerEmployee(emp);
		Iterable<Employee> itEmps = empService.getAllEmployees();
		// keep the result in model attribute
		map.put("resultMsg", msg);
		map.put("empList", itEmps);
		// return LVN
		return "redirect:emp_report";
	}

	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		// use service
		Employee emp1 = empService.getEmployeeByNo(no);
		// copy data
		BeanUtils.copyProperties(emp1, emp);
		// return LVN
		return "update_employee";
	}

	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		// use service
		String msg = empService.updateEmployee(emp);
		// add the result msg as flash attribute
		attrs.addFlashAttribute("resultMsg", msg);
		// redirect the direct
		return "redirect:emp_report";
	}

	@GetMapping("/emp_delete")
	public String deleteEmployeee(RedirectAttributes attrs, @RequestParam int no) {
		// use service
		String msg = empService.deleteEmployeeById(no);
		// keep the result in flash attribute
		attrs.addFlashAttribute("resultMsg", msg);
		// redirect the request
		return "redirect:emp_report";
	}

}