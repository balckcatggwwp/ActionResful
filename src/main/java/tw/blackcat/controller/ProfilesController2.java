package tw.blackcat.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProfilesController2 {

	@PostMapping("/profiles.controller")
	public String processAction(@RequestParam String userName,@RequestParam String userAddress,@RequestParam String userPhone) {
		return "message:" + userName + "-" + userAddress + "-" + userPhone;
	}
	
	@PostMapping("/profiles.controller3")
	public String processAction2(@RequestParam String userName) {
		return "message:" + userName;
	}
	
	
}
