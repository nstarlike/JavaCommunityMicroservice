package nstarlike.jcm.user.service.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import nstarlike.jcm.user.dto.UserDto;
import nstarlike.jcm.user.dto.DepartmentDto;
import nstarlike.jcm.user.dto.ResponseDto;
import nstarlike.jcm.user.model.User;
import nstarlike.jcm.user.service.UserService;
import nstarlike.jcm.user.repository.UserRepository;
import nstarlike.jcm.user.service.DepartmentFeignClient;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private DepartmentFeignClient departmentFeignClient;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getById(Long id) {
		User user = userRepository.findById(id).get();
		UserDto userDto = mapToUserDto(user);

		DepartmentDto departmentDto = departmentFeignClient.getById(user.getDepartmentId());
		
		ResponseDto responseDto = new ResponseDto();
		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);
		return responseDto;
	}
	
	private UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

}
