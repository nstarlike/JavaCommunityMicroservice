package nstarlike.jcm.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.Message;

import lombok.AllArgsConstructor;

import org.apache.kafka.clients.admin.NewTopic;

import nstarlike.jcm.user.dto.UserDto;
import nstarlike.jcm.user.dto.UserEvent;
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
	private NewTopic newTopic;
	private KafkaTemplate<String, UserEvent> kafkaTemplate;
	
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

	@Override
	public void sendMessage(UserEvent userEvent) {
		Message<UserEvent> message = MessageBuilder
				.withPayload(userEvent)
				.setHeader(KafkaHeaders.TOPIC, newTopic.name())
				.build();
		kafkaTemplate.send(message);
	}

}
