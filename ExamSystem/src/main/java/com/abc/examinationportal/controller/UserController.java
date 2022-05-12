package com.abc.examinationportal.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.examinationportal.model.ApiResponse;
import com.abc.examinationportal.model.ForgetPasswordDto;
import com.abc.examinationportal.model.LoginDto;
import com.abc.examinationportal.model.SignUpDto;
import com.abc.examinationportal.service.UserService;
 
 

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<SignUpDto> register(@RequestBody SignUpDto signUpDto) {
		SignUpDto userDetails = userService.signUp(signUpDto);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginDto loginDto) {
		ApiResponse loginDetails = userService.login(loginDto);
		return new ResponseEntity<>(loginDetails, HttpStatus.OK);
	}

	@PostMapping("/forgetpassword")
	public ResponseEntity<ApiResponse> forgetPassword(@RequestBody ForgetPasswordDto forgetPasswordDto) {
		ApiResponse securityDetails = userService.forgetPassword(forgetPasswordDto);
		return new ResponseEntity<>(securityDetails, HttpStatus.OK);
	}

	@PutMapping("/resetpassword")
	public ResponseEntity<SignUpDto> resetPassword(@RequestBody SignUpDto signUpDto) {
		SignUpDto updatedPassword = userService.updatePassword(signUpDto);
		return new ResponseEntity<>(updatedPassword, HttpStatus.OK);
	}

	@GetMapping("/getbyemail/{pemail}")
	public ResponseEntity<SignUpDto> fetchUserDetails(@PathVariable("pemail") String email) {
		SignUpDto userdetails = userService.getUserByEmail(email);
		return new ResponseEntity<>(userdetails, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<SignUpDto> fetchAllUsers() {
		return userService.getAllUsers();
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteUser(@PathVariable("pid") int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User Deleted successfully with id: " + id, HttpStatus.OK);
	}

}
