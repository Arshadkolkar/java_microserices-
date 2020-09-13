/**
 * 
 */
package com.sca.security.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.security.UserDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface UserService {

	/**
	 * 
	 * @param accessToken
	 * @param userDto
	 */
	void registerUser(String accessToken, UserDto userDto);

	/**
	 * 
	 * @param accessToken
	 * @param userDto
	 */
	void updateUser(String accessToken, UserDto userDto);

	/**
	 * 
	 * @param accessToken
	 * @param userId
	 * @return
	 */
	UserDto getUserByUserId(String accessToken, Long userId);

	/**
	 * 
	 * @param accessToken
	 * @param userName
	 * @return
	 */
	UserDto getUserByMemberId(String accessToken, String memberId);

	/**
	 * 
	 * @param accessToken
	 * @param emailId
	 * @return
	 */
	UserDto getUserByEmail(String accessToken, String emailId);

	/**
	 * 
	 * @param accessToken
	 * @param companyName
	 * @return
	 */
	List<UserDto> getUsersByCompanyName(String accessToken, String companyName);

	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	List<UserDto> getAllUsers(String accessToken);

	/**
	 * 
	 * @param userDto
	 */
	void loginUser(UserDto userDto);

	/**
	 * 
	 * @param userDto
	 */
	void logoutUser(String accessToken, UserDto userDto);

	UserDto getUserProfile(String accessToken, String userId, String refreshToken);

}
