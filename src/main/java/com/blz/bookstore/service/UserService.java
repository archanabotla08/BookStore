package com.blz.bookstore.service;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blz.bookstore.dto.ForgetPasswordDTO;
import com.blz.bookstore.dto.LoginDTO;
import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.dto.ResetPasswordDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.UserModel;
import com.blz.bookstore.repository.UserRepository;
import com.blz.utility.EmailSender;
import com.blz.utility.JwtGenerator;

@Service
@Component
public class UserService implements IUserService {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailSender emailSender;
	
	 private static final String VERIFICATION_URL = "http://localhost:8080/verify/";
//	 private static final String RESETPASSWORD_URL = "http://localhost:8080/user/resetpassword?token=";
	 private static final String RESETPASSWORD_URL = "http://localhost:8080/swagger-ui.html#/user-controller/resetPasswordUsingPOST";
	 
	@Override
	public boolean  register(RegistrationDTO registrationDTO) throws UserException {
		Optional<UserModel> isEmailAvaliable = userRepository.findByEmailId(registrationDTO.getEmailId());
		if(isEmailAvaliable.isPresent()) {
			return false;
		}
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(registrationDTO, userModel);
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userRepository.save(userModel);
		return true;
	}
	
	  private String getResponse(long userId) {
	        String response="\t\t\t\t\t\tThanking you for Registartion with us\n\n"+"Click on the below link for the verification\n\n"
	                +VERIFICATION_URL + JwtGenerator.createJWT(userId);
	        return  response;
	    }

	@Override
	public String login(LoginDTO loginDTO) throws UserException {
		Optional<UserModel> userCheck = userRepository.findByEmailId(loginDTO.getEmailId());
		if(!userCheck.isPresent()) {
			throw new UserException("No User Found", UserException.ExceptionType.INVALID_USER);
		}
		if(bCryptPasswordEncoder.matches(loginDTO.getPassword(), userCheck.get().getPassword())) {
			String token = JwtGenerator.createJWT(userCheck.get().getUserId());
			userRepository.save(userCheck.get());
			return token;
		}
		throw new UserException("Incorrect Credentials", UserException.ExceptionType.INVALID_CREDENTIALS);
	}

	@Override
	public boolean verify(String token) throws UserException {
		long id = JwtGenerator.decodeJWT(token);
		UserModel userModel = userRepository.findById(id).get();
		if(id > 0 && userModel != null) {
			if(!userModel.isVerify()) {
				userRepository.save(userModel);
				return true;
			}
			throw new UserException("User Already Verified", UserException.ExceptionType.ALREADY_VERIFIED);
		}
		return false;
	}

	@Override
	public ResponseDTO forgetPassword(ForgetPasswordDTO userModel) throws MessagingException {
		
		UserModel isUserIdExists = userRepository.findByEmailId(userModel.getEmailId()).get();
		System.out.printf("id: ",isUserIdExists);
		
		
		if(isUserIdExists != null ) {	//&& isUserIdExists.isVerify()
			String token = JwtGenerator.createJWT(isUserIdExists.getUserId());
			String reponse = RESETPASSWORD_URL ;
			emailSender.send(userModel.getEmailId(),"Reset Password Verification URL",reponse,token);
			
			return new ResponseDTO(HttpStatus.OK.value(), "Link For ResetPassword", reponse);
		}	
		return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Email verfication Fail");
	}

	@Override
	public boolean resetPassword(ResetPasswordDTO resetPassword, String token) throws UserException {
		if(resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword())) {
			long id = JwtGenerator.decodeJWT(token);
			UserModel isUserIdExists = userRepository.findById(id).get();
			if(isUserIdExists != null) {
			isUserIdExists.setPassword(bCryptPasswordEncoder.encode((resetPassword.getNewPassword())));
			userRepository.save(isUserIdExists);
			return true;
		}
		throw new UserException("User Not Exists", UserException.ExceptionType.INVALID_USER);
	}
	return false;
	}
}