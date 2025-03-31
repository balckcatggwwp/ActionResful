package tw.blackcat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.Bird;
import tw.blackcat.model.BirdService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BirdController {
	@Autowired
	private BirdService bService;
	
	@GetMapping("/birdinsert.controller")
	public Bird processInserAction() {
		Bird bird1 = new Bird("bluebird","S","blue",1);
		return bService.insert(bird1);
	}
	@GetMapping("/birdupdate.controller")
	public Bird processupdateAction() {
		Bird bird2 = new Bird(103,"bluebird","M","deepblue",3);
		return bService.insert(bird2);
	}
	@GetMapping("/birddelete.controller")
	public String processdeleteAction() {
		bService.deleteById(104);
		return "Delete OK";
	}
	
	@GetMapping("/birdquerybyid.controller")
	public Bird processQueryByIdAction() {
		Bird resultBean = bService.selectById(100);
		return resultBean;

	}
	
	@GetMapping("/birdqueryall.controller")
	public List<Bird> processQueryAllAction(){
		return bService.selectAll();
	}

	
	
}
