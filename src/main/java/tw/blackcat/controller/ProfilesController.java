package tw.blackcat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.Profiles;
import tw.blackcat.model.ProfilesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class ProfilesController {
	@Autowired
	private ProfilesService pService;
	
	@PostMapping("/profiles")
	public String processInsertAction(@RequestParam String userName, @RequestParam String userAddress, 
			                          @RequestParam String userPhone) {
		Profiles insertBean = new Profiles(userName, userAddress, userPhone);
		pService.inser(insertBean);
		return "insert ok";		
	}
	
	@PostMapping("/profiles1")
	public Profiles processInsertAction(@RequestBody Profiles p) {
		return pService.inser(p);
	}
	
	@GetMapping("/profiles/{profilesid}")
	public String processQueryByIdAction(@PathVariable int profilesid) {  //@PathVariable(name = "profilesid") int profilesid
		Profiles queryBean = pService.selectById(profilesid);
		if(queryBean!=null) {
			return queryBean.getId() + " " + queryBean.getName() + " " + queryBean.getAddress() + " " + queryBean.getPhone();
		}
		return "no result";
	}
	
	@GetMapping("/profiles")
	public Profiles processQueryByNAmeAndAddressAction(@RequestBody Profiles p) {
		return pService.selectByNameAndAddress(p.getName(), p.getAddress());
	}
	
	@GetMapping("/profiles1")
	public List<Profiles> processQueryAllAction(){
		return pService.selectAll();
	}
	
	@PutMapping("/profiles/{profilesid}")
	public String processUpdateByIdAction(@PathVariable int profilesid, @RequestParam String userName, @RequestParam String userAddress, @RequestParam String userPhone) {
		Profiles updateBean = new Profiles(profilesid, userName, userAddress, userPhone);
		pService.update(updateBean);
		return "update ok";
	}
	
	@PutMapping("/profiles")
	public Profiles processUpdateAction(@RequestBody Profiles p) {
		return pService.update(p);
	}
	
	@DeleteMapping("/profiles/{profilesid}")
	public String processDeleteById(@PathVariable int profilesid) {
		Profiles resultBean = pService.selectById(profilesid);
		
		if(resultBean!=null) {
			pService.deleteById(profilesid);
			return "delete ok";
		}
		
		return "delete not ok";
	}
}
