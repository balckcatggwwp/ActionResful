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

@Entity@Table(name = "bird")@Component
@Getter@Setter@NoArgsConstructor
public class Bird {
	@Id @Column(name = "BID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@Column(name = "BNAME")
	private String bname;
	@Column(name = "SIZE")
	private String size;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "AGE")
	private int age;
	
	public Bird( String bname, String size, String color, int age) {
		super();
		
		this.bname = bname;
		this.size = size;
		this.color = color;
		this.age = age;
	}

	public Bird(int bid, String bname, String size, String color, int age) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.size = size;
		this.color = color;
		this.age = age;
	}
	
}
