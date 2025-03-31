package tw.blackcat.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@Component
@Data
public class Users {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
}
