package nstarlike.jcm.user.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import lombok.AllArgsConstructor;

import nstarlike.jcm.user.model.User;
import nstarlike.jcm.user.dto.ResponseDto;
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
}
