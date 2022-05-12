package com.abc.examinationportal.service;

import java.util.List;

import com.abc.examinationportal.model.ApiResponse;
import com.abc.examinationportal.model.ForgetPasswordDto;
import com.abc.examinationportal.model.LoginDto;
import com.abc.examinationportal.model.SignUpDto;

 

public interface UserService {

	public SignUpDto signUp(SignUpDto signUpDto);

	public ApiResponse login(LoginDto loginDto);

	public ApiResponse forgetPassword(ForgetPasswordDto forgetPasswordDto);

	public SignUpDto updatePassword(SignUpDto signUpDto);

	public SignUpDto getUserByEmail(String email);

	public List<SignUpDto> getAllUsers();

	public void deleteUser(int id);

}