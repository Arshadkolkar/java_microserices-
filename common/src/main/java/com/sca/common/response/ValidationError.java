/**
 * 
 */
package com.sca.common.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 * @author subhash
 *
 */
public class ValidationError {

	private int code;
	private String message;

	/**
	 * 
	 */
	@JacksonXmlElementWrapper(localName = "args")
	@JacksonXmlProperty(localName = "arg")
	@JsonProperty("args")
	List<Object> argList;

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessageWithArgs(String message) {
		this.message = String.format(message, argList.toArray());
	}

	/**
	 * 
	 * @param args
	 */
	public void setArgList(List<Object> args) {
		this.argList = args;
	}

	/**
	 * 
	 * @param arg
	 */
	public void addArg(Object arg) {
		if (argList == null)
			argList = new ArrayList<Object>();

		argList.add(arg);
	}

	/**
	 * 
	 * @return
	 */
	public List<Object> getArgList() {
		return argList;
	}
}