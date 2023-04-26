package nstarlike.jcm.user.service;

import nstarlike.jcm.user.model.User;
import nstarlike.jcm.user.dto.ResponseDto;
import nstarlike.jcm.user.dto.UserEvent;

public interface UserService {
	User save(User user);
	ResponseDto getById(Long id);
	void sendMessage(UserEvent userEvent);
}
