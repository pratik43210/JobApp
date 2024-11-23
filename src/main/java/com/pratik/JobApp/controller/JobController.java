package com.pratik.JobApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pratik.JobApp.model.JobPost;
import com.pratik.JobApp.service.JobService;

@Controller
public class JobController {
	@Autowired
	private JobService service;
	
//	@RequestMapping({"/", "home"})
	@GetMapping({"/", "home"})
	public String home() {
		return "home";
	}
	@GetMapping("addjob")
	public String addJob() {
		return "addjob";
	}
	@GetMapping("viewalljobs")
//	public String viewAllJobs(Model m) {
//		List<JobPost> jobPosts=service.getAllJobs();
//		m.addAttribute("jobPosts",jobPosts);
//		
//		return "viewalljobs";
//	}
	public ModelAndView viewAllJobs(ModelAndView mv) {
		List<JobPost> jobPosts=service.getAllJobs();
		mv.addObject("jobPosts", jobPosts);
		mv.setViewName("viewalljobs");
		
		return mv;
	}
	@PostMapping("handleForm")
	public String handleForm(JobPost jobPost) {
		service.addJob(jobPost);
		return "success";
	}

}
