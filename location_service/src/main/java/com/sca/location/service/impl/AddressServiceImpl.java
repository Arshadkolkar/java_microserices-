/**
 * 
 */
package com.sca.location.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.address.AddressValidationException;
import com.sca.dao.domain.location.Address;
import com.sca.dao.domain.location.AddressType;
import com.sca.dao.domain.security.User;
import com.sca.dao.repository.location.LocationRepository;
import com.sca.dto.location.AddressDto;
import com.sca.location.service.AddressService;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private LocationRepository locationRepository;

	/**
	 * 
	 */
	@Override
	public void createAddress(String accesstoken, AddressDto addressDto) throws AddressValidationException {

		if (addressDto != null) {

			AddressValidationException addressValidationException = new AddressValidationException(addressDto);
			if ((addressValidationException.getValidationResponse() != null)
					&& (addressValidationException.getValidationResponse().isSuccess() == false)) {
				throw addressValidationException;
			}

			Address address = new Address();

			// Address Type Information
			AddressType addressType = new AddressType();
			addressType.setAddressTypeId(addressDto.getAddressTypeId());
			address.setAddressType(addressType);
			address.setScaUserId(addressDto.getScaUserId());
			// address.setAddressTypeId(addressDto.getAddressTypeId());
			address.setCompanyName(addressDto.getCompanyName());
			address.setContactEmail(addressDto.getContactEmail());
			address.setContactFirstName(addressDto.getContactFirstName());
			address.setContactLastName(addressDto.getContactLastName());
			address.setContactPhone(addressDto.getContactPhone());
			address.setAddressLine1(addressDto.getAddressLine1());
			address.setAddressLine2(addressDto.getAddressLine2());
			address.setCity(addressDto.getCity());
			address.setState(addressDto.getState());
			address.setZip(addressDto.getZip());
			address.setCountry(addressDto.getCountry());
			if (addressDto.isDefaultAddress()) {
				locationRepository.changeDefaultAddress(addressDto.getScaUserId(), addressDto.getAddressTypeId());
			}
			address.setDefault(addressDto.isDefaultAddress());

			locationRepository.save(address);

			addressDto.setAddressId(address.getAddressId());
			addressDto = this.copyToAddressDto(addressDto, address);
		}

	}

	/**
	 * 
	 */
	@Override
	public void updateAddress(String accessToken, AddressDto addressDto) throws InvalidInputException {

		Optional<Address> addressOptional = locationRepository.findById(addressDto.getAddressId());

		if (addressOptional.isPresent()) {
//			femsUserService.putAddressProfile(addressDto);

			AddressValidationException addressValidationException = new AddressValidationException(addressDto);
			if ((addressValidationException.getValidationResponse() != null)
					&& (addressValidationException.getValidationResponse().isSuccess() == false)) {
				throw addressValidationException;
			}

			Address address = addressOptional.get();

			// Address Type Information
			AddressType addressType = new AddressType();
			addressType.setAddressTypeId(addressDto.getAddressTypeId());
			address.setAddressType(addressType);
			address.setScaUserId(addressDto.getScaUserId());
			address.setCompanyName(addressDto.getCompanyName());
			address.setContactEmail(addressDto.getContactEmail());
			address.setContactFirstName(addressDto.getContactFirstName());
			address.setContactLastName(addressDto.getContactLastName());
			address.setContactPhone(addressDto.getContactPhone());
			address.setAddressLine1(addressDto.getAddressLine1());
			address.setAddressLine2(addressDto.getAddressLine2());
			address.setCity(addressDto.getCity());
			address.setState(addressDto.getState());
			address.setZip(addressDto.getZip());
			address.setCountry(addressDto.getCountry());

			if (addressDto.isDefaultAddress()) {
				locationRepository.changeDefaultAddress(addressDto.getScaUserId(), addressDto.getAddressTypeId());
			}
			address.setDefault(addressDto.isDefaultAddress());
			
			locationRepository.save(address);
		} else {
			throw new InvalidInputException("Could not find address to update");
		}

	}

	/**
	 * 
	 */
	@Override
	public List<AddressDto> getAddresses(String accessToken, Long scaUserId) {

		List<AddressDto> addressDtoList = null;
					
		List<Address> addressList = locationRepository.findByScaUserId(scaUserId);
		if ((addressList != null) && (addressList.size() > 0)) {
			addressDtoList = new ArrayList<AddressDto>();

			for (Address address : addressList) {
				addressDtoList.add(this.copyToAddressDto(null, address));
			}
		}

		return addressDtoList;

	}

	private AddressDto copyToAddressDto(AddressDto addressDto, Address address) {

		if (address != null) {

			if (addressDto == null) {
				addressDto = new AddressDto();
			}

			addressDto.setScaUserId(address.getScaUserId());
			addressDto.setAddressId(address.getAddressId());
			addressDto.setAddressTypeId(address.getAddressType().getAddressTypeId());
			addressDto.setAddressTypeName(address.getAddressType().getName());
			addressDto.setCompanyName(address.getCompanyName());
			addressDto.setContactEmail(address.getContactEmail());
			addressDto.setContactFirstName(address.getContactFirstName());
			addressDto.setContactLastName(address.getContactLastName());
			addressDto.setContactPhone(address.getContactPhone());
			addressDto.setAddressLine1(address.getAddressLine1());
			addressDto.setAddressLine2(address.getAddressLine2());
			addressDto.setCity(address.getCity());
			addressDto.setState(address.getState());
			addressDto.setZip(address.getZip());
			addressDto.setCountry(address.getCountry());
			addressDto.setDefaultAddress(address.isDefault());

		}

		return addressDto;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteAddress(String accessToken, Long addressId) {

		if ((addressId != null) && (addressId > 0)) {
			locationRepository.deleteById(addressId);
		}
		return true;
	}

	/**
	 * 
	 */
	@Override
	public AddressDto getAddress(String accessToken, Long addressId) {

		AddressDto addressDto = null;
		if ((addressId != null) && (addressId > 0)) {
			Address address = locationRepository.getOne(addressId);
			addressDto = this.copyToAddressDto(null, address);
		}
		return addressDto;
	}

}
