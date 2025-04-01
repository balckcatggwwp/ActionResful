package tw.blackcat.product.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.blackcat.product.model.Product;
import tw.blackcat.product.model.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@GetMapping("/producuquerymainaction.controller")
	public String processQueryAllMainAction() {
		return "product/productQueryAll";
	}
	
	@PostMapping("/query/{pid}")
	@ResponseBody
	public Product processQueryById(@PathVariable int pid) {
		return pService.findbyid(pid);
	}
	
	@PostMapping("/queryall")
	@ResponseBody
	public List<Product> processQueryAllAction(){
		return pService.findall();
	}
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public HashMap<String, Object> processQueryByPage(@PathVariable Integer pageNo){
		
		int pageSize = 3;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Product> page = pService.findbypage(pageable);
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("totalPages", page.getTotalPages());
		maps.put("totalElements", page.getTotalElements());
		maps.put("content", page.getContent());
		
		return maps;
	}
}
