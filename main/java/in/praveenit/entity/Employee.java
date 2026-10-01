package in.praveenit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Ramana")
public class Employee {

	@Id
	private int id;
	private String name;
	private Double salary;

}
