package tw.blackcat.controller;

import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.House;
import tw.blackcat.model.HouseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class JsonCreatorController {
	@Autowired
	private HouseService houseService;
	
	
	@GetMapping("/jsoncreator.controller")
	public List<House> processAction() {
		return houseService.findAll();
	}
	
}
