/**
 * This is the controller for User service
 */
package com.sca.security.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.security.UserDto;
import com.sca.dto.security.Users;
import com.sca.security.service.UserService;
import com.sca.security.util.Constants;

/**
 * 
 * @author subhash
 *
 */
@RestController
@RequestMapping(Constants.USER_REST_URL)
public class UserController {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param accessToken
	 * @param userDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> registerUser(
			@RequestHeader(value = "access-token", required = true) String accessToken, @RequestBody UserDto userDto)
			throws GenericException {

		ValidationResponse response = null;

		try {

			userService.registerUser(accessToken, userDto);

			response = new ValidationResponse();
			if (userDto.getStatusCode() != 200) {
				response.setMessage(userDto.getErrorMessage());
				response.setSuccess(false);
			} else {
				response.setMessage(userDto);
			}
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to register the User with email id = " + userDto.getEmail());
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param userDto
	 * @return
	 * @throws GenericException
	 */
	@PutMapping
	public ResponseEntity<ValidationResponse> updateUser(
			@RequestHeader(value = "access-token", required = true) String accessToken, @RequestBody UserDto userDto)
			throws GenericException {

		ValidationResponse response = null;

		try {

			userService.updateUser(accessToken, userDto);

			response = new ValidationResponse();
			if (userDto.getStatusCode() != 200) {
				response.setMessage(userDto.getErrorMessage());
				response.setSuccess(false);
			} else {
				response.setMessage(userDto);
			}
		} catch (Exception ex) {
			exceptionUtil.processException(ex,
					"Failed to update the User details for user id = " + userDto.getScaUserId());
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param scaUserId
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/{scaUserId}")
	public ResponseEntity<UserDto> getUserByScaUserId(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "scaUserId", required = true) Long scaUserId) throws GenericException {

		UserDto userDto = null;

		try {

			if (scaUserId > 0) {
				userDto = userService.getUserByUserId(accessToken, scaUserId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get User details for User Id = " + scaUserId);
		}

		return ResponseEntity.ok(userDto);
	}

	@GetMapping(value = "/profile")
	public ResponseEntity<ValidationResponse> getUserProfile(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "refreshToken", required = true) String refreshToken) throws GenericException {

		UserDto userDto = null;
		ValidationResponse response = null;
		try {
			response = new ValidationResponse();
			userDto = userService.getUserProfile(accessToken, userId, refreshToken);
			response.setMessage(userDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get User details for User Id = " + userId);
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param userName
	 * @param emailId
	 * @param companyName
	 * @return
	 * @throws GenericException
	 */
	@GetMapping
	public ResponseEntity<ValidationResponse> getUsers(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "memberId", required = false) String memberId,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "companyName", required = false) String companyName) throws GenericException {

		ValidationResponse response = null;
		Users users = null;

		try {

			List<UserDto> userList = null;

			if ((memberId == null) && (email == null) && (companyName != null)) {
				userList = userService.getUsersByCompanyName(accessToken, companyName);
			} else if (email != null) {
				userList = new ArrayList<UserDto>();
				userList.add(userService.getUserByEmail(accessToken, email));
			} else if (memberId != null) {
				userList = new ArrayList<UserDto>();
				userList.add(userService.getUserByMemberId(accessToken, memberId));
			} else {
				userList = userService.getAllUsers(accessToken);
			}

			if ((userList == null) || (userList.size() < 1)) {
				throw new InvalidInputException("No users found for search criteria");
			} else {
				users = new Users();
				users.setUserList(userList);
			}

			response = new ValidationResponse();
			response.setMessage(users);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Users");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param userDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<ValidationResponse> loginUser(@RequestBody UserDto userDto) throws GenericException {

		ValidationResponse response = null;

		try {
			response = new ValidationResponse();
			userService.loginUser(userDto);
			if (userDto.getStatusCode() != 200) {
				response.setMessage(userDto.getErrorMessage());
				response.setSuccess(false);
			} else {
				response.setMessage(userDto);
			}
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to login the user with username = " + userDto.getMemberId());
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param userDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping(value = "/logout")
	public ResponseEntity<ValidationResponse> logoutUser(
			@RequestHeader(value = "access-token", required = true) String accessToken, @RequestBody UserDto userDto)
			throws GenericException {

		ValidationResponse response = null;

		try {

			userService.logoutUser(accessToken, userDto);

			response = new ValidationResponse();
			response.setMessage(userDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to logout the user with username = " + userDto.getMemberId());
		}

		return ResponseEntity.ok(response);
	}

}