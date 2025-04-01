package tw.blackcat.product.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public Product findbyid(Integer id) {
		Optional<Product> op = productRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	public List<Product> findall(){
		return productRepository.findAll();
	}
	public Page<Product> findbypage(Pageable pageable){
		return productRepository.findAll(pageable);
	}
}
