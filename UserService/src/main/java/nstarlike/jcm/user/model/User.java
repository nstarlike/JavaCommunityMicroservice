package nstarlike.jcm.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator="UsersSeq")
	@SequenceGenerator(name="UsersSeq", sequenceName="users_seq", allocationSize=5)
	private Long id;
	private String name;
	@Column(nullable=false, unique=true)
	private String email;
	private Long departmentId;
}
