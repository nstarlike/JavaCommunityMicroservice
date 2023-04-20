package nstarlike.jcm.department.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="departments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String address;
	private String code;
}
