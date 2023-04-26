package nstarlike.jcm.user.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import nstarlike.jcm.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
	private String message;
	private String status;
	private User user;
}
