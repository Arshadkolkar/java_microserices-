/**
 * 
 */
package com.sca.location.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.location.AddressDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface AddressService {

	/**
	 * 
	 * @param accessToken
	 * @param userId
	 * @param addressDto
	 */
	void createAddress(String accessToken, AddressDto addressDto);

	/**
	 * 
	 * @param accessToken
	 * @param addressDto
	 */
	void updateAddress(String accessToken, AddressDto addressDto);
	
	/**
	 * 
	 * @param accessToken
	 * @param addressID
	 * @return
	 */
	AddressDto getAddress(String accessToken, Long addressId);

	/**
	 * 
	 * @param accessToken
	 * @param userId
	 * @return
	 */
	List<AddressDto> getAddresses(String accessToken, Long userId);

	/**
	 * 
	 * @param accessToken
	 * @param addressID
	 * @return
	 */
	boolean deleteAddress(String accessToken, Long addressId);

	

}
