package comt.tieunt.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comt.tieunt.springboot.model.Info;

@Controller
public class HelloWorldController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		List<Info> profile = new ArrayList<>();
		profile.add(new Info("fullname", "Nguyễn Tài Tiêu"));
		profile.add(new Info("nickname", "tieunt"));
		profile.add(new Info("gmail", "tieunt.bk97@gmail.com"));
		profile.add(new Info("facebook", "https://www.facebook.com/tieunt.bk97"));
		profile.add(new Info("website", "https://tieunt97.github.io/portfolio/#/"));
		
		model.addAttribute("tieuntProfile", profile);
		
		
		
		return "profile";
	}
}
