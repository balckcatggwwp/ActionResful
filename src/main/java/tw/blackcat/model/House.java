package tw.blackcat.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "house")
@Component
@Setter
@Getter
@NoArgsConstructor
public class House {
	@Id@Column(name="HOUSEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int houseid;
	private String housename;
	public House(int houseid, String housename) {
		super();
		this.houseid = houseid;
		this.housename = housename;
	}
	public House(String housename) {
		super();
		this.housename = housename;
	}
	
	
	
	
}
