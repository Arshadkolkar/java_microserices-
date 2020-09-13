package com.sca.security.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.UnauthorizedException;
import com.sca.dao.domain.security.User;
import com.sca.dao.domain.security.UserLogin;
import com.sca.dao.repository.security.UserLoginRepository;
import com.sca.dao.repository.security.UserRepository;
import com.sca.dto.security.UserDto;
import com.sca.fems.service.FemsUserService;

@Service
@Transactional
public class UserServiceImpl implements com.sca.security.service.UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private FemsUserService femsUserService;

	/**
	 * 
	 */
	@Override
	public void registerUser(String accessToken, UserDto userDto) {

		if (userDto != null) {

			femsUserService.registerUser(accessToken, userDto);
			if (userDto.getStatusCode() == 200) {
				User user = new User();
				user.setCompanyName(userDto.getCompanyName());
				user.setEmail(userDto.getEmail());
				user.setFirstName(userDto.getFirstName());
				user.setLastName(userDto.getLastName());
				user.setPassword(userDto.getPassword());
				user.setPhoneNumber(userDto.getPhoneNumber());
				user.setMemberId(userDto.getMemberId());
				user.setUserId(userDto.getUserId());
				user.setScaUserId(user.getScaUserId());

				if (userDto.getRefreshToken() != null) {
					user.setRefreshToken(userDto.getRefreshToken());
				}

				userRepository.save(user);

				userDto.setScaUserId(user.getScaUserId());
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public void updateUser(String accessToken, UserDto userDto) throws InvalidInputException {

		if (userDto != null) {
			Optional<User> userOptional = userRepository.findById(userDto.getScaUserId());

			if (userOptional.isPresent()) {
				femsUserService.updateUserProfile(accessToken, userDto);
				if (userDto.getStatusCode() == 200) {
					User user = userOptional.get();
					this.updateLocalCopy(user, userDto);
				}

			} else {
				throw new InvalidInputException("Could not find user to update");
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public UserDto getUserByUserId(String accessToken, Long scaUserId) {

		User user = userRepository.getOne(scaUserId);
		UserDto userDto = this.copyToUserDto(user, null);

		return userDto;
	}

	private UserDto copyToUserDto(User user, UserDto userDto) {

		if (user != null) {

			if (userDto == null) {
				userDto = new UserDto();
			}

			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setEmail(user.getEmail());
			userDto.setPhoneNumber(user.getPhoneNumber());
			userDto.setCompanyName(user.getCompanyName());
			// userDto.setLastLoginDate(user.getLastLoginDate()!=null?user.getLastLoginDate().toString():"");
			// userDto.setLastOrderDate(user.getLastOrderDate()!=null?user.getLastOrderDate().toString():"");
			// userDto.setLogoutDate(user.getLogoutDate()!=null?user.getLogoutDate().toString():"");
			userDto.setUserId(user.getUserId());
			userDto.setJobTitle(user.getJobTitle());

			userDto.setFax(user.getFax());

			userDto.setAddressLine1(user.getAddressLine1());

			userDto.setAddressLine2(user.getAddressLine2());

			userDto.setCity(user.getCity());

			userDto.setState(user.getState());

			userDto.setCountry(user.getCountry());

			userDto.setZip(user.getZip());

			userDto.setWebAccountManagerName(user.getWebAccountManagerName());

			userDto.setWebAccountMangerEmail(user.getWebAccountMangerEmail());

			userDto.setWebAccountManagerPhone(user.getWebAccountManagerPhone());

			userDto.setMarketoScore(user.getMarketoScore());

			userDto.setLifecycleTag(user.getLifecycleTag());

			userDto.setSdrname(user.getSdrname());
			userDto.setCompanyName(user.getCompanyName());
			userDto.setEmail(user.getEmail());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setPassword(user.getPassword());
			userDto.setPhoneNumber(user.getPhoneNumber());
			userDto.setScaUserId(user.getScaUserId());
			userDto.setUserId(user.getUserId());
			userDto.setMemberId(user.getMemberId());

			Optional<UserLogin> userLoginOptional = userLoginRepository.findById(userDto.getScaUserId());
			if (userLoginOptional.isPresent() == true) {
				UserLogin userLogin = userLoginOptional.get();
				userDto.setAccessToken(userLogin.getAccessToken());
				userDto.setLastLoginDate(userLogin.getLoginDate());
				userDto.setLogoutDate(userLogin.getLogoutDate());
			}
		}

		return userDto;
	}

	/**
	 * 
	 */
	@Override
	public void loginUser(UserDto userDto) {

		femsUserService.loginUser(userDto);

		/*
		 * User user = null; if (userDto != null) { user =
		 * userRepository.findByMemberIdOrEmail(userDto.getMemberId(),
		 * userDto.getEmail()); this.updateLocalCopy(user, userDto);
		 * saveUserLogin(userDto); } else { throw new
		 * UnauthorizedException(String.format("No User found for UserEmail: %s",
		 * userDto.getEmail())); }
		 */
	}

	private void saveUserLogin(UserDto userDto) {

		if (userDto != null) {
			Optional<UserLogin> userLoginOptional = userLoginRepository.findById(userDto.getScaUserId());

			UserLogin userLogin = new UserLogin();
			if (userLoginOptional.isPresent() == false) {

				userLogin.setScaUserId(userDto.getScaUserId());
			} else {
				userLogin = userLoginOptional.get();
			}

			userLogin.setAccessToken(userDto.getAccessToken());
			userLogin.setLoginDate(Calendar.getInstance());
			userLogin.setLogoutDate(null);
			userLogin.setSessionId(userDto.getSessionId());

			userLoginRepository.save(userLogin);

			userDto.setLastLoginDate(userLogin.getLoginDate());
			userDto.setLogoutDate(userLogin.getLogoutDate());
		}
	}

	/**
	 * 
	 */
	@Override
	public void logoutUser(String accessToken, UserDto userDto) {

		// Logout from Fems
		boolean femsStatus = logoutFromFems(userDto.getAccessToken());

		if (femsStatus == true) {
			saveUserLogout(userDto);
		}

	}

	private boolean logoutFromFems(String accessToken) {
		return true;
	}

	private void saveUserLogout(UserDto userDto) {

		Optional<UserLogin> userLoginOptional = userLoginRepository.findById(userDto.getScaUserId());

		UserLogin userLogin = new UserLogin();
		if (userLoginOptional.isPresent() == false) {

			userLogin.setScaUserId(userDto.getScaUserId());
		} else {
			userLogin = userLoginOptional.get();
		}

		userLogin.setLogoutDate(Calendar.getInstance());

		userLoginRepository.save(userLogin);

		userDto.setLastLoginDate(userLogin.getLoginDate());
		userDto.setLogoutDate(userLogin.getLogoutDate());

	}

	/**
	 * 
	 */
	@Override
	public UserDto getUserByMemberId(String accessToken, String memberId) {
		User user = userRepository.findByMemberIdOrEmail(memberId, null);
		UserDto userDto = this.copyToUserDto(user, null);
		return userDto;
	}

	/**
	 * 
	 */
	@Override
	public UserDto getUserByEmail(String accessToken, String email) {
		User user = userRepository.findByMemberIdOrEmail(null, email);
		UserDto userDto = this.copyToUserDto(user, null);
		return userDto;
	}

	/**
	 * 
	 */
	@Override
	public List<UserDto> getUsersByCompanyName(String accessToken, String companyName) {

		List<UserDto> userDtoList = null;

		List<User> userList = userRepository.findByCompanyName(companyName);

		if ((userList != null) && (userList.size() > 0)) {
			userDtoList = new ArrayList<UserDto>();

			for (User user : userList) {
				userDtoList.add(this.copyToUserDto(user, null));
			}
		}

		return userDtoList;
	}

	/**
	 * 
	 */
	@Override
	public List<UserDto> getAllUsers(String accessToken) {

		List<UserDto> userDtoList = null;

		List<User> userList = userRepository.findAll();

		if ((userList != null) && (userList.size() > 0)) {
			userDtoList = new ArrayList<UserDto>();

			for (User user : userList) {
				userDtoList.add(this.copyToUserDto(user, null));
			}
		}

		return userDtoList;
	}

	@Override
	public UserDto getUserProfile(String accessToken, String userId, String refreshToken) {

		User user = userRepository.findByUserId(userId);

		UserDto userDto = null;
		if (user != null) {
			userDto = this.copyToUserDto(user, null);
		} else {
			// Call fems API get the user profile
			userDto = new UserDto();
			userDto.setAccessToken(accessToken);
			userDto.setUserId(userId);
			userDto.setRefreshToken(refreshToken);
		}

		userDto = femsUserService.getUserProfile(accessToken, userDto);
		this.updateLocalCopy(user, userDto);

		return userDto;
	}

	private void updateLocalCopy(User user, UserDto userDto) {

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		// user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setCompanyName(userDto.getCompanyName());
		user.setLastLoginDate(userDto.getLastLoginDate() != null ? userDto.getLastLoginDate().toString() : "");
		user.setLastOrderDate(userDto.getLastOrderDate() != null ? userDto.getLastOrderDate().toString() : "");
		user.setLogoutDate(userDto.getLogoutDate() != null ? userDto.getLogoutDate().toString() : "");
		user.setUserId(userDto.getUserId());
		user.setJobTitle(userDto.getJobTitle());

		user.setFax(userDto.getFax());

		user.setAddressLine1(userDto.getAddressLine1());

		user.setAddressLine2(userDto.getAddressLine2());

		user.setCity(userDto.getCity());

		user.setState(userDto.getState());

		user.setCountry(userDto.getCountry());

		user.setZip(userDto.getZip());

		user.setWebAccountManagerName(userDto.getWebAccountManagerName());

		user.setWebAccountMangerEmail(userDto.getWebAccountMangerEmail());

		user.setWebAccountManagerPhone(userDto.getWebAccountManagerPhone());

		user.setMarketoScore(userDto.getMarketoScore());

		user.setLifecycleTag(userDto.getLifecycleTag());

		user.setSdrname(userDto.getSdrname());
		userRepository.save(user);
	}

}
