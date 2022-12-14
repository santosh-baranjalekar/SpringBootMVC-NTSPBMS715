package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataRenderingController {

	/*@RequestMapping("/process")
	public String process(Map<String, Object> map) {
		System.out.println("SharedMemoryObjectClassName:: " + map.getClass());
		// add model attributes to shared memory
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", LocalDateTime.now());
		// return LVN
		return "show_data";
	}*/
	
	/*@RequestMapping("/process")
	public String process(Model model) {
		System.out.println("SharedMemoryObjectClassName:: " + model.getClass());
		// add model attributes to shared memory
		model.addAttribute("Attribute1", "Value1");
		model.addAttribute("CurrentDate", LocalDateTime.now());
		// return LVN
		return "show_data";
	}*/
	
	/*@RequestMapping("/process")
	public String process(ModelMap map) {
		System.out.println("SharedMemoryObjectClassName:: " + map.getClass());
		// add model attributes to shared memory
		map.addAttribute("Attribute1", "Value1");
		map.addAttribute("CurrentDate", LocalDateTime.now());
		// return LVN
		return "show_data";
	}*/
	
	
    //Taking Handler Method return type as Model(I)
	/*@RequestMapping("/process") //Here the LVN is RequestPath(process)
	public Model process() {
		Model model=new BindingAwareModelMap(); //manually created shared memory
		model.addAttribute("Attribute1", "Value1");
		model.addAttribute("CurrentDate", LocalDateTime.now());
		// return LVN
		return model;
	}*/
	
	// Taking Handler Method return type as Map<String,Object>
	/*@RequestMapping("/process") // Here the LVN is RequestPath(process)
	public Map<String,Object> process() {
		//create shared memory
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", LocalDateTime.now());
		// return LVN
		return map;
	}*/
	
	//Taking ModelAndView(legacy style)as the return type of handler method
	/*@RequestMapping("/process") // Here the LVN is RequestPath(process)
	public ModelAndView process() {
		//create shared memory
		ModelAndView modelview=new ModelAndView();
		modelview.addObject("Attribute1", "Value1");
		modelview.addObject("CurrentDate", LocalDateTime.now());
		modelview.setViewName("show_data");
		// return LVN
		return modelview;
	}*/
	
	//If the return type of handler method is void?
	//Ans:It takes "process"(request path)as the logical view name
	/*@RequestMapping("/process") // Here the LVN is RequestPath(process)
	public void process(Map<String,Object>map) {
		//add attributes
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", new Date());
	}*/
	
	//What happens if the handler method return null ?
	//Ans::It takes "show_data"(request path) as the logical view name
	/*@RequestMapping("/show_data")
	public String process(Map<String,Object>map) {
		//add attributes
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", new Date());
		//return LVN
		return null;
	}*/
	
	//forwarding request from one handler method to another handler method
	/*@RequestMapping("/process")
	public String process() {
		System.out.println("DataRenderingController.process()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport(Map<String,Object>map) {
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", new Date());
		System.out.println("DataRenderingController.showReport()");
		//return LVN
		return "show_data";
	}*/
	
	//How can we redirect one handler method request to another handler method
	/*@RequestMapping("/process")
	public String process(HttpServletRequest req) {
		System.out.println("DataRenderingController.process():: "+req.hashCode());
		req.setAttribute("Attribute1", "Value1");
		req.setAttribute("CurrentDate", new Date());
		return "redirect:report";
	}
	
	@RequestMapping("/report")
	public String showReport(HttpServletRequest req) {
		System.out.println("Req Attributes:: "+req.getAttribute("Attribute1"));//gives null
		System.out.println("DataRenderingController.showReport()");
		//return LVN
		return "show_data";
	}*/
	
	//How to get request,response object in the handler method
	/*@RequestMapping("/show_data")
	public String showData(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("DataRenderingController.showData():: "+req.hashCode()+"   "+res.hashCode());
		req.setAttribute("Attribute1", "Value1");
		req.setAttribute("CurrentDate", new Date());
		return "show_data";
	}*/
	
	//How to pass HttpSession Object to handler method of controller class\
	/*@RequestMapping("/show_data")
	public String showData(HttpSession ses) {
		System.out.println("DataRenderingController.showData():: "+ses.hashCode()+"  "+ses.getClass());
		ses.setAttribute("Attribute1", "Value1");
		ses.setAttribute("CurrentDate", new Date());
		return "show_data";
	}*/
	
	//How to pass ServletConfig object and ServletContext obj to controller class handler method
	/*@Autowired
	private ServletConfig config;
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("Servlet Name:: "+config.getServletName());
		System.out.println("Context Path:: "+context.getContextPath());
		map.put("Attribute1", "Value1");
		map.put("CurrentDate", new Date());
		//return LVN
		return "process";
	}*/
	
	//How to send output from Handler method directly to browser without involving ViewResolver and View Comps?
	@RequestMapping("/process")
	public void process(HttpServletResponse res) throws Exception {
		//get printwriter obj
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write data to browser software
		pw.println("<b>Directly from Handler Method</b>");
	}
	

}