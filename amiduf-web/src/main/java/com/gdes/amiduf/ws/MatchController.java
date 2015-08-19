package com.gdes.amiduf.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

	@RequestMapping("/test")
	public String hello() {
		return "hello GDES";
	}
}
