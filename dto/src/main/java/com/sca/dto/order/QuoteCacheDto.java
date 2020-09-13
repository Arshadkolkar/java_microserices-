/**
 * 
 */
package com.sca.dto.order;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;

import com.sca.dao.domain.order.QuoteCacheData;

/**
 * 
 * @author subhash
 *
 */
public class QuoteCacheDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long quoteCacheDataId;
	private String wmqId;
	private String pcbQuantity;
	private String pcbTurntime;
	private String quoteRequestJSON;
	private String quoteResponsePriceMatrixJSON;
	private String designFile;
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

	/**
	 * 
	 */
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	public String getPcbQuantity() {
		return pcbQuantity;
	}

	public void setPcbQuantity(String pcbQuantity) {
		this.pcbQuantity = pcbQuantity;
	}

	public String getPcbTurntime() {
		return pcbTurntime;
	}

	public void setPcbTurntime(String pcbTurntime) {
		this.pcbTurntime = pcbTurntime;
	}

	/**
	 * 
	 * @return
	 */
	public QuoteCacheData convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, QuoteCacheData.class);
	}
}
