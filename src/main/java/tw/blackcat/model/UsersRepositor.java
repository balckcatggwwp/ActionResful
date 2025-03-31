package tw.blackcat.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositor extends JpaRepository<Users, Integer> {
	public Users findByUserName(String username);
}
