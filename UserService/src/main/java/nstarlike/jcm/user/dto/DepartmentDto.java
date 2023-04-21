package nstarlike.jcm.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private Long id;
	private String name;
	private String address;
	private String code;
}
