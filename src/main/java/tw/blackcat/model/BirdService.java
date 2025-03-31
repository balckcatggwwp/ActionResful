package tw.blackcat.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BirdService {

	@Autowired
	private  BirdRepository birdRepo;

  
	public Bird insert(Bird bird) {
		return birdRepo.save(bird);
	}
	public Bird update(Bird bird) {
		return birdRepo.save(bird);
	}
	public void deleteById(Integer id) {
		birdRepo.deleteById(id);
	}
	public Bird selectById(Integer id) {
		Optional<Bird> op = birdRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	public List<Bird> selectAll() {
		return birdRepo.findAll();
	}
}
