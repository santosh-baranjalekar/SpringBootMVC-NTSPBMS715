package com.nt.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.nt.model.Student;

@Controller
public class StudentController {

	@GetMapping("/") // To show Home Page
	public String showHome() {
		System.out.println("StudentController.showHome()");
		// return LVN
		return "welcome";
	}

	@GetMapping("register") // To launch form page
	public String showForm() {
		// return LVN
		return "student_register";
	}

	@PostMapping("/register")
	public String processStudent(Map<String, Object> map, @ModelAttribute("stud") Student st) {
		// generate result
		String grade = null;
		if (st.getAvg() >= 75)
			grade = "First Class with Distinction";
		else if (st.getAvg() >= 60)
			grade = "First Class";
		else if (st.getAvg() >= 50)
			grade = "Second Class";
		else if (st.getAvg() >= 35)
			grade = "Third Class";
		else
			grade = "Fail";
		// keep results in model attribute
		map.put("result", grade);
		// return LVN
		return "show_result";
	}

}