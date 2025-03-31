package tw.blackcat.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfilesService {
	@Autowired
	private ProfilesRepository profilesRepo;
	
	public Profiles inser(Profiles p) {
		return profilesRepo.save(p);
		
	}
	public Profiles update(Profiles p) {
		return profilesRepo.save(p);
		
	}
	public void deleteById(Integer id) {
		profilesRepo.deleteById(id);
		
	}
	public Profiles selectById(Integer id) {
		Optional<Profiles> op = profilesRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	public Profiles selectByNameAndAddress(String name, String address) {
		return profilesRepo.findByNameAndAddress(name, address);
	}
	public List<Profiles> selectAll() {
		return profilesRepo.findAll();
	}

}