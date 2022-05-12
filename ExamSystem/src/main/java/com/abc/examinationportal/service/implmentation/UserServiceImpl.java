package com.abc.examinationportal.service.implmentation;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.examinationportal.entity.UserEntity;
import com.abc.examinationportal.exception.IncorrectAnswerException;
import com.abc.examinationportal.exception.InvalidRoleException;
import com.abc.examinationportal.exception.PasswordMismatchException;
import com.abc.examinationportal.exception.UserAlreadyExistsException;
import com.abc.examinationportal.exception.UserNotFoundException;
import com.abc.examinationportal.model.ApiResponse;
import com.abc.examinationportal.model.ForgetPasswordDto;
import com.abc.examinationportal.model.LoginDto;
import com.abc.examinationportal.model.SignUpDto;
import com.abc.examinationportal.repository.UserRepository;
import com.abc.examinationportal.service.UserService;
import com.abc.examinationportal.util.EntityModelUtil;
 

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public SignUpDto signUp(SignUpDto signUpDto) throws UserAlreadyExistsException {
		UserEntity userEntity = null;
		List<UserEntity> list = userRepository.findUsersByEmail(signUpDto.getEmail());
		if (!(list.isEmpty())) {
			throw new UserAlreadyExistsException(" Oops!  There is already a user registered with this email.");
		} else {
			userEntity = userRepository.save(EntityModelUtil.userModelToEntity(signUpDto));
		}

		return EntityModelUtil.userEntityToModel(userEntity);
	}
	
	 
	@Override
	public ApiResponse login(LoginDto loginDto)
			throws UserNotFoundException, PasswordMismatchException, InvalidRoleException {

		UserEntity user = userRepository.findByEmail(loginDto.getEmail());
		if (user == null) {
			throw new UserNotFoundException("User does not exist with this email id.");
		}
		if (!user.getPassword().equals(loginDto.getPassword())) {
			throw new PasswordMismatchException("Password mismatch.");
		}
		if (!user.getRole().equals(loginDto.getRole())) {
			throw new InvalidRoleException("no user registered with this role ");
		}
		return new ApiResponse(200, "Login sucess", "u have successfully logged in:");
	}
 
	@Override
	public ApiResponse forgetPassword(ForgetPasswordDto forgetPasswordDto)
			throws IncorrectAnswerException, UserNotFoundException {

		UserEntity user = userRepository.findByEmail(forgetPasswordDto.getEmail());
		if (user == null) {
			throw new UserNotFoundException("Sorry! User is not existing with this Email ");
		}
		if (!user.getSecurityAnswer().equals(forgetPasswordDto.getSecurityAnswer())) {
			throw new IncorrectAnswerException("answer is incorrect.");
		}

		return new ApiResponse(200, "you can reset password", " security question answered correctly");
	}
	
 
	@Override
	public SignUpDto updatePassword(SignUpDto signUpDto) throws UserNotFoundException {

		UserEntity user = userRepository.findByEmail(signUpDto.getEmail());

		if (user == null) {
			throw new UserNotFoundException("User does not exist with this email id.");
		}

		UserEntity updatedUserEntity = userRepository.save(EntityModelUtil.userModelToEntity(signUpDto));

		return EntityModelUtil.userEntityToModel(updatedUserEntity);
	}
	 
	@Override
	public SignUpDto getUserByEmail(String email) throws UserNotFoundException {

		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UserNotFoundException("Sorry! User is not existing with this Email ");
		}
		return EntityModelUtil.userEntityToModel(userEntity);
	}
	
	 
	@Override
	public List<SignUpDto> getAllUsers() {
		return EntityModelUtil.userEntityToModelList(userRepository.findAll());
	}
	
	 
	@Override
	public void deleteUser(int id) throws UserNotFoundException {

		Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

		if (optionalUserEntity.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new UserNotFoundException("Sorry! User is not existing with id: " + id);
		}
	}

}
