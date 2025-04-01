package tw.blackcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.Users;
import tw.blackcat.model.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@PostMapping(path = "/accountcheck.controller")
	public ResponseEntity<String> checkuser(@RequestBody Users users) {
		System.out.println(users);
		boolean status = usersService.checklogin(users);
		if(status) {
			return new ResponseEntity<String>("Y",HttpStatus.OK);
		}
		return new ResponseEntity<String>("N",HttpStatus.OK);
	}
	
}
