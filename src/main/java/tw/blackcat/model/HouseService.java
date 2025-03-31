package tw.blackcat.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
	@Autowired
	private HouseRepository houseRepository;
	
	
	public House findbyid(Integer id) {
		Optional<House>op= houseRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
				
	}
	public List<House> findAll() {
		return houseRepository.findAll();
	}
	
	
	
	
	
}
