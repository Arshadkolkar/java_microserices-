/**
 * 
 */
package com.sca.order.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.dto.order.QuoteCacheDto;

/**
 * 
 * @author subhash
 *
 */
public interface QuoteCacheService {

	/**
	 * 
	 * @param accessToken
	 * @param quoteCacheDto
	 */
	void saveQuoteCacheData(String accessToken, QuoteCacheDto quoteCacheDto);

	/**
	 * 
	 * @param accessToken
	 * @param wmqId
	 * @return
	 */
	QuoteCacheDto getQuoteCacheData(String accessToken, String wmqId);

	/**
	 * 
	 * @param accessToken
	 * @param wmqId
	 * @param userId
	 * @param quoteCacheDto
	 * @return quote details i.e price matrix and part information
	 */
	JsonNode getQuoteDetails(String accessToken, String wmqId, String userId, QuoteCacheDto quoteCacheDto);

}
