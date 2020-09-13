package com.sca.dao.domain.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;

@Entity
@Table(name = "quote_cache_data")
public class QuoteCacheData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quote_cache_data_id")
	private Long quoteCacheDataId;
	
	@Column(name = "wmq_id")
	private String wmqId;

	@Column(name = "quote_request_json", columnDefinition="TEXT")
	private String quoteRequestJSON;

	@Column(name = "quote_response_price_matrix_json", columnDefinition="TEXT")
	private String quoteResponsePriceMatrixJSON;
	
	@Column(name = "design_file")
	private String designFile;
	
	@Column(name = "electrical_testing_cost")
	private String electricalTestingCost;
	
	/**
	 * @return the quoteCacheDataId
	 */
	public Long getQuoteCacheDataId() {
		return quoteCacheDataId;
	}

	/**
	 * @param quoteCacheDataId the quoteCacheDataId to set
	 */
	public void setQuoteCacheDataId(Long quoteCacheDataId) {
		this.quoteCacheDataId = quoteCacheDataId;
	}

	/**
	 * @return the wmqId
	 */
	public String getWmqId() {
		return wmqId;
	}

	/**
	 * @param wmqId the wmqId to set
	 */
	public void setWmqId(String wmqId) {
		this.wmqId = wmqId;
	}
	
	/**
	 * @return the quoteRequestJSON
	 */
	public String getQuoteRequestJSON() {
		return quoteRequestJSON;
	}

	/**
	 * @param quoteRequestJSON the quoteRequestJSON to set
	 */
	public void setQuoteRequestJSON(String quoteRequestJSON) {
		this.quoteRequestJSON = quoteRequestJSON;
	}

	/**
	 * @return the quoteResponsePriceMatrixJSON
	 */
	public String getQuoteResponsePriceMatrixJSON() {
		return quoteResponsePriceMatrixJSON;
	}

	/**
	 * @param quoteResponsePriceMatrixJSON the quoteResponsePriceMatrixJSON to set
	 */
	public void setQuoteResponsePriceMatrixJSON(String quoteResponsePriceMatrixJSON) {
		this.quoteResponsePriceMatrixJSON = quoteResponsePriceMatrixJSON;
	}

	/**
	 * @return the designFile
	 */
	public String getDesignFile() {
		return designFile;
	}

	/**
	 * @param designFile the designFile to set
	 */
	public void setDesignFile(String designFile) {
		this.designFile = designFile;
	}

	/**
	 * @return the electricalTestingCost
	 */
	public String getElectricalTestingCost() {
		return electricalTestingCost;
	}

	/**
	 * @param electricalTestingCost the electricalTestingCost to set
	 */
	public void setElectricalTestingCost(String electricalTestingCost) {
		this.electricalTestingCost = electricalTestingCost;
	}
}