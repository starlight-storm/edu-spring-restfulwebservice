package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // ControllerとRestControllerの違いを発見する
public class SampleController {

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
}