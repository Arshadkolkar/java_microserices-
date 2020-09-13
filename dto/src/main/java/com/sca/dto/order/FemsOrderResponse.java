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
public class FemsOrderResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderNumber;
	private Double orderSubTotal;
	private Double shippingCharges;
	private Double calculatedTax;
	private Double orderTotal;
	private String promisedShipDate;
	public FemsOrderResponse(OrderDto orderDto) {
		this.orderNumber = orderDto.getOrderNumber();
		this.orderSubTotal = orderDto.getOrderSubTotal();
		this.shippingCharges = orderDto.getShippingCharges();
		this.calculatedTax = orderDto.getCalculatedTax();
		this.orderTotal = orderDto.getOrderTotal();
		this.promisedShipDate = orderDto.getPromisedShipDate();
		
		
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Double getOrderSubTotal() {
		return orderSubTotal;
	}
	public void setOrderSubTotal(Double orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}
	public Double getShippingCharges() {
		return shippingCharges;
	}
	public void setShippingCharges(Double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public Double getCalculatedTax() {
		return calculatedTax;
	}
	public void setCalculatedTax(Double calculatedTax) {
		this.calculatedTax = calculatedTax;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getPromisedShipDate() {
		return promisedShipDate;
	}
	public void setPromisedShipDate(String promisedShipDate) {
		this.promisedShipDate = promisedShipDate;
	}


}
