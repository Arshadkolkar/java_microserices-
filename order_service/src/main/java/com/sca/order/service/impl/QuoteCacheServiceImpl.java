/**
 * 
 */
package com.sca.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;

import com.sca.common.exception.quoteCache.QuoteCacheValidationException;
import com.sca.dao.domain.order.QuoteCacheData;
import com.sca.dao.repository.order.QuoteCacheRepository;
import com.sca.dto.order.QuoteCacheDto;
import com.sca.fems.service.FemsQuoteService;
import com.sca.order.service.QuoteCacheService;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public class QuoteCacheServiceImpl implements QuoteCacheService {

	@Autowired
	private QuoteCacheRepository quoteCacheRepository;

	@Autowired
	private FemsQuoteService femsQuoteService;

	/**
	 * 
	 */
	@Override
	public void saveQuoteCacheData(String accessToken, QuoteCacheDto quoteCacheDto) {

		if (quoteCacheDto != null) {

			QuoteCacheValidationException quoteCacheValidationException = new QuoteCacheValidationException(
					quoteCacheDto);
			if ((quoteCacheValidationException.getValidationResponse() != null)
					&& (quoteCacheValidationException.getValidationResponse().isSuccess() == false)) {
				throw quoteCacheValidationException;
			}

			QuoteCacheData quoteCacheData = new QuoteCacheData();
			quoteCacheData.setQuoteCacheDataId(quoteCacheDto.getQuoteCacheDataId());
			quoteCacheData.setWmqId(quoteCacheDto.getWmqId());
			quoteCacheData.setQuoteRequestJSON(quoteCacheDto.getQuoteRequestJSON());
			quoteCacheData.setQuoteResponsePriceMatrixJSON(quoteCacheDto.getQuoteResponsePriceMatrixJSON());
			quoteCacheData.setDesignFile(quoteCacheDto.getDesignFile());
			quoteCacheData.setElectricalTestingCost(quoteCacheDto.getElectricalTestingCost());

			quoteCacheData = quoteCacheRepository.save(quoteCacheData);

			quoteCacheDto.setQuoteCacheDataId(quoteCacheData.getQuoteCacheDataId());
		}

	}

	/**
	 * 
	 */
	@Override
	public QuoteCacheDto getQuoteCacheData(String accessToken, String wmqId) {

		QuoteCacheData quoteCacheData = quoteCacheRepository.findByWmqId(wmqId);
		QuoteCacheDto quoteCacheDto = this.copyToQuoteCacheDto(quoteCacheData);

		return quoteCacheDto;
	}

	private QuoteCacheDto copyToQuoteCacheDto(QuoteCacheData quoteCacheData) {

		QuoteCacheDto quoteCacheDto = null;

		if (quoteCacheData != null) {
			quoteCacheDto = new QuoteCacheDto();
			quoteCacheDto.setQuoteCacheDataId(quoteCacheData.getQuoteCacheDataId());
			quoteCacheDto.setWmqId(quoteCacheData.getWmqId());
			quoteCacheDto.setQuoteRequestJSON(quoteCacheData.getQuoteRequestJSON());
			quoteCacheDto.setQuoteResponsePriceMatrixJSON(quoteCacheData.getQuoteResponsePriceMatrixJSON());
			quoteCacheDto.setDesignFile(quoteCacheData.getDesignFile());
			quoteCacheDto.setElectricalTestingCost(quoteCacheData.getElectricalTestingCost());
		}

		return quoteCacheDto;
	}

	/**
	 * quote details i.e price matrix and part information from FEMS
	 */
	@Override
	public JsonNode getQuoteDetails(String accessToken, String wmqId, String userId, QuoteCacheDto quoteCacheDto) {

		JsonNode partAndQuoteDetials = femsQuoteService.getQuoteDetails(accessToken, wmqId, userId, quoteCacheDto);
		return partAndQuoteDetials;
	}
}
