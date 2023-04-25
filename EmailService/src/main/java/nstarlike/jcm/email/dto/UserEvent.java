package nstarlike.jcm.email.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import nstarlike.jcm.email.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
	private String message;
	private String status;
	private User user;
}
