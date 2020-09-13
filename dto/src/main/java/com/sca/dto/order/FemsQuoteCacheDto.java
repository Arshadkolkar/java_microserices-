/**
 * 
 */
package com.sca.dto.order;

import java.io.Serializable;

/**
 * 
 * @author
 *
 */
public class FemsQuoteCacheDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pcbQuantity;
	private String pcbTurntime;
	private String wqID;
	public FemsQuoteCacheDto(QuoteCacheDto quoteCacheDto) {
		this.pcbQuantity = quoteCacheDto.getPcbQuantity();
		this.pcbTurntime = quoteCacheDto.getPcbTurntime();
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
	public String getWqID() {
		return wqID;
	}
	public void setWqID(String wqID) {
		this.wqID = wqID;
	}

}
