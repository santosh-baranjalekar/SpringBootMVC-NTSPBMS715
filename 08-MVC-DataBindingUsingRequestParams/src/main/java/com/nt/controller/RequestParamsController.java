package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamsController {
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&sname=Santosh
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no, @RequestParam("sname") String name) {
		System.out.println(no + "   " + name);
		// return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1002&sname=Ravi
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1003&name=Raju
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&name=santosh
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam(required=false)String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&name=santosh
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&sname=king
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam(defaultValue="RRR")String sname) {
		System.out.println(sno+"    "+sname);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=101f&sname=raja
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,@RequestParam("sname")String name) {
		System.out.println(no+"    "+name);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=&sname=raja
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,@RequestParam("sname")String name) {
		System.out.println(no+"    "+name);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=&sname=santosh
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno",defaultValue="2001") int no,@RequestParam("sname")String name) {
		System.out.println(no+"    "+name);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=&sname=raja
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno",required=false) Integer no,@RequestParam("sname")String name) {
		System.out.println(no+"    "+name);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=101&sname=raja&sadd=delhi&sadd=vizag&sadd=mumbai
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno",required=false) Integer no,
			              @RequestParam("sname")String name,
			              @RequestParam("sadd")String addrs[],
			              @RequestParam("sadd")List<String>saddList,
			              @RequestParam("sadd")Set<String>saddSet) {
		System.out.println(no+"    "+name+"   "+Arrays.toString(addrs)+"   "+saddList+"   "+saddSet);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&sname=santosh&sadd=delhi,vizag,mumbai
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno",required=false) Integer no,
			              @RequestParam("sname")String name,
			              @RequestParam("sadd")String addrs) {
		System.out.println(no+"    "+name+"   "+addrs);
		//return LVN
		return "show_result";
	}*/
	
	//http://localhost:8585/08-MVC-DataBindingUsingRequestParams/data?sno=1001&sname=santosh&sadd=delhi&avg=90.90&school=HPS
	@GetMapping("/data")
	public String process(@RequestParam Integer sno,@RequestParam String sname,@RequestParam("sadd") String addrs) {
		System.out.println(sno+"  "+sname+"   "+addrs);
		//return LVN
		return "show_result";
	}

}