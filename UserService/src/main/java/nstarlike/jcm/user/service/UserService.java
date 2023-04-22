package nstarlike.jcm.user.service;

import nstarlike.jcm.user.model.User;
import nstarlike.jcm.user.dto.ResponseDto;

public interface UserService {
	User save(User user);
	ResponseDto getById(Long id);
}
