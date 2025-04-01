package tw.blackcat.product.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Component
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pname;
	private int price;
	private int quantity;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date pdate;
	private String note;
}
