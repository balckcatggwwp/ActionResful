package tw.blackcat.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Integer> {
	public Profiles findByNameAndAddress(String name, String address);
}
