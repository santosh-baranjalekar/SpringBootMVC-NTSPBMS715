package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class AllDataRenderingOptionsController {
	
	//passing simple values
	/*@GetMapping("/")
	public String sendData(Map<String,Object> map) {
		//put simple values in model attributes
		map.put("name", "Raja");
		map.put("age", 30);
		//Return LVN
		return "show_report";
	}*/
	
	//passing collection and arrays
	/*@GetMapping("/")
	public String sendData(Map<String,Object>map) {
		//put arrays collection as the  model attribute values
		map.put("favColours", new String[] {"Red","Green","Yellow","Pink"});
		map.put("nickNames",List.of("Raja","Raj","Maharaj","Sonu"));
		map.put("phoneNumbers", Set.of(999999L,888888L,777777L,666666L));
		map.put("idDetails", Map.of("AadharNo",123,"VoterId",321));
		//return LVN
		return "show_data";
	}*/
	
	//passing model class object
	/*@GetMapping("/")
	public String sendData(Map<String,Object>map) {
		//create model class object with data
		Employee emp=new Employee();
		emp.setEno(1001);
		emp.setEname("Raja");
		emp.setSalary(9000.0);
		emp.setVaccinated(true);
		//add model class object to model attribute
		map.put("empInfo", emp);
		//return LVN
		return "show";
	}*/
	
	//passing collection of model class object
	@GetMapping("/")
	public String sendData(Map<String,Object>map) {
		//create collection of model class object
		List<Employee> empList=List.of(new Employee(1001,"Raja",9000.0,true),
		                               new Employee(1002,"Rani",10000.0,false),
		                               new Employee(1003,"Santosh",11000.0,true));
		//add collection of model class object to model attribute
		map.put("empListInfo", empList);
		//return LVN
		return "emp_data";
	}

}
