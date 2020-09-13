package com.sca.order.service.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.order.QuoteCacheDto;
import com.sca.order.service.QuoteCacheService;

class QuoteCacheControllerTest {

	@InjectMocks
	QuoteCacheController quoteCacheController;

	@Mock
	QuoteCacheService quoteCacheService;

	QuoteCacheDto quoteCacheDto;

	QuoteCacheDto quoteCacheList = null;
	JsonNode webQuoteDetails=null;

	// private Long quoteCacheDataId = 1L;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		quoteCacheDto = new QuoteCacheDto();

		quoteCacheDto.setWmqId("wmqid1234");
		quoteCacheDto.setQuoteRequestJSON("quote request json");
		quoteCacheDto.setQuoteResponsePriceMatrixJSON("response matrix");
		quoteCacheDto.setDesignFile("design file");
		quoteCacheDto.setElectricalTestingCost("electrical testing cost");

	}

	@Test
	void testSaveQuoteCacheData() throws GenericException {

		quoteCacheService.saveQuoteCacheData("123", quoteCacheDto);
		ResponseEntity<ValidationResponse> response = quoteCacheController.saveQuoteCacheData("123", quoteCacheDto);
		assertNotNull(response);

		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	void testGetQuoteCacheData() throws GenericException {

		when(quoteCacheService.getQuoteCacheData("123", "wmqid1234")).thenReturn(quoteCacheList);
		ResponseEntity<QuoteCacheDto> quoteCacheDtoList = quoteCacheController.getQuoteCacheData("123", "wmqid1234");

		assertNotNull(quoteCacheDtoList);

		assertEquals(200, quoteCacheDtoList.getStatusCodeValue());
	}
	
	@Test
	void testWebQuoteDetails() throws GenericException {

		when(quoteCacheService.getQuoteDetails("123", "wmq1234","du45uh3434",quoteCacheDto)).thenReturn(webQuoteDetails);
		ResponseEntity<ValidationResponse> webQuoteDetails = quoteCacheController.getQuoteDetails("123", "wmqid1234","du45uh3434",quoteCacheDto);

		assertNotNull(webQuoteDetails);

	}

}
