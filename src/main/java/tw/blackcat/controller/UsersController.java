package tw.blackcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("/login/{}")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
