/**
 * This is the controller for User service
 */
package com.sca.location.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.sca.dto.location.AddressDto;
import com.sca.dto.location.Addresses;
import com.sca.location.service.AddressService;
import com.sca.location.util.Constants;

/**
 * 
 * @author subhash
 *
 */

@RestController
@RequestMapping(Constants.ADDRESS_REST_URL)
public class AddressController {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(UserController.class);

	@Autowired
	private AddressService addressService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param accessToken
	 * @param addressDto
	 * @return
	 * @throws GenericException
	 */

	@PostMapping
	public ResponseEntity<ValidationResponse> createAddress(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody AddressDto addressDto) throws GenericException {

		ValidationResponse response = null;

		try {

			addressService.createAddress(accessToken, addressDto);

			response = new ValidationResponse();
			response.setSuccess(true);
			response.setMessage(addressDto);
		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create address for an User");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param addressDto
	 * @return
	 * @throws GenericException
	 */
	@PutMapping
	public ResponseEntity<ValidationResponse> updateAddress(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody AddressDto addressDto) throws GenericException {

		ValidationResponse response = null;
		try {

			addressService.updateAddress(accessToken, addressDto);
			response = new ValidationResponse();

			response.setMessage(addressDto);
			response.setSuccess(true);
		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update address for an User");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param addressId
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/{addressId}")
	public ResponseEntity<ValidationResponse> getAddresses(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "addressId", required = false) Long addressId) throws GenericException {

		ValidationResponse response = null;

		try {

			AddressDto addressDetails = addressService.getAddress(accessToken, addressId);

			response = new ValidationResponse();
			response.setMessage(addressDetails);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get address");
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
	@GetMapping
	public ResponseEntity<ValidationResponse> getUserAddresses(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "scaUserId", required = true) Long scaUserId) throws GenericException {

		ValidationResponse response = null;
		Addresses addresses = null;

		try {

			List<AddressDto> addressList = addressService.getAddresses(accessToken, scaUserId);

			if ((addressList == null) || (addressList.size() < 1)) {
				throw new InvalidInputException("No addresses found for scaUserId = " + scaUserId);
			} else {
				addresses = new Addresses();
				addresses.setAddressList(addressList);
			}

			response = new ValidationResponse();
			response.setMessage(addresses);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get addresses for scaUserId = " + scaUserId);
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param addressId
	 * @return
	 * @throws GenericException
	 */
	@DeleteMapping(value = "/{addressId}")
	public ResponseEntity<ValidationResponse> deleteAddress(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "addressId", required = true) Long addressId) throws GenericException {

		ValidationResponse response = null;

		try {

			addressService.deleteAddress(accessToken, addressId);

			response = new ValidationResponse();
			response.setMessage("Deleted address successfully");
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to delete address");
		}

		return ResponseEntity.ok(response);
	}
}