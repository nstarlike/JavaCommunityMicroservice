package nstarlike.jcm.user.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nstarlike.jcm.user.dto.ResponseDto;
import nstarlike.jcm.user.dto.UserEvent;
import nstarlike.jcm.user.model.User;
import nstarlike.jcm.user.service.UserService;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@RefreshScope
public class UserController {
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		User savedUser = userService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDto> getById(@PathVariable("id") Long id){
		ResponseDto responseDto = userService.getById(id);
		return ResponseEntity.ok(responseDto);
	}
	
	@GetMapping("{id}/sendEmail")
	public ResponseEntity<ResponseDto> sendEmail(@PathVariable("id") Long id){
		ResponseDto responseDto = userService.getById(id);
		User user = new User();
		user.setId(responseDto.getUser().getId());
		user.setName(responseDto.getUser().getName());
		user.setEmail(responseDto.getUser().getEmail());
		UserEvent userEvent = new UserEvent();
		userEvent.setMessage("Hello! " + responseDto.getUser().getName() + " This is a test email. "
				+ "I am testing for an asynchronous communication using Apache Kafka Message Broker."
				+ "Message will be sended from UserService to EmailService.");
		userEvent.setStatus("SENDING");
		userEvent.setUser(user);
		userService.sendMessage(userEvent);
		return ResponseEntity.ok(responseDto);
	}
}
