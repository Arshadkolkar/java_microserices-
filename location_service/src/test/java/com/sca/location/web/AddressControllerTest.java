package com.sca.location.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.location.AddressDto;
import com.sca.dto.payment.CreditCardDto;
import com.sca.location.service.AddressService;

class AddressControllerTest {

	@InjectMocks
	AddressController addressController;

	@Mock
	AddressService addressService;

	AddressDto addressDto;
	
	List<AddressDto> addressList = null;
	
	private Long addressId = 1L;
	
	private Long scaUserId = null;


	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		addressDto = new AddressDto();

		addressDto.setScaUserId(1L);
		addressDto.setAddressTypeId(1L);
		addressDto.setContactFirstName("Harsha");
		addressDto.setContactLastName("vardhan");
		addressDto.setContactEmail("vardhan@gmail.com");
		addressDto.setContactPhone("7204571480");
		addressDto.setCompanyName("Sieera");
		addressDto.setAddressLine1("first cross");
		addressDto.setAddressLine2("second cross");
		addressDto.setCity("Ballari");
		addressDto.setState("Karnataka");
		addressDto.setZip(583101);
		addressDto.setCountry("India");
		addressDto.setDefaultAddress(false);

	}

	@Test
	void testCreateAddress() throws GenericException {
		
		addressService.createAddress("123", addressDto);

		ResponseEntity<ValidationResponse> response = addressController.createAddress("123",
				addressDto);

		assertNotNull(response);

		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	void testUpdateAddress() throws GenericException {
		
		addressService.updateAddress("", addressDto);;

		ResponseEntity<ValidationResponse> response = addressController.updateAddress("123", addressDto);

		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	void testGetAddresses()  throws GenericException  {
		
		when(addressService.getAddresses("123",addressId)).thenReturn(addressList);

		ResponseEntity<ValidationResponse> addressDtoList = addressController.getAddresses("123", addressId);

		assertNotNull(addressDtoList);

		assertEquals(200, addressDtoList.getStatusCodeValue());
		
		
	}

	@Test
	void testGetUserAddresses() throws GenericException {
		when(addressService.getAddresses("123",scaUserId)).thenReturn(addressList);

		ResponseEntity<ValidationResponse> addressDtoList = addressController.getAddresses("123", scaUserId);

		assertNotNull(addressDtoList);

		assertEquals(200, addressDtoList.getStatusCodeValue());
	}

	@Test
	void testDeleteAddress() throws GenericException {
		
		when(addressService.deleteAddress("123",scaUserId)).thenReturn(true);

		ResponseEntity<ValidationResponse> addressDtoList = addressController.deleteAddress("123", scaUserId);

		assertNotNull(addressDtoList);

		assertEquals(200, addressDtoList.getStatusCodeValue());
	}

}
