package com.blz.bookstore.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.model.UserModel;
import com.blz.bookstore.repository.UserRepository;

import jdk.jshell.spi.ExecutionControl.UserException;

@Service
@Component
public class UserService implements IUserService {
	
	@Autowired
	public UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public boolean  register(RegistrationDTO registrationDTO) throws UserException {
		Optional<UserModel> isEmailAvaliable = userRepository.findByEmailId(registrationDTO.getEmailId());
		if(isEmailAvaliable.isPresent()) {
			return false;
		}
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(registrationDTO, userModel);
//		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userRepository.save(userModel);
		return true;
	}

	
	

}
