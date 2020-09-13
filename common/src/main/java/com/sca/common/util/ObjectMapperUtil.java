/**
 * 
 */
package com.sca.common.util;

import java.io.IOException;
import java.net.URLDecoder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author subhash
 *
 */
public class ObjectMapperUtil {

	/**
	 * 
	 * @param <T>
	 * @param jsonString
	 * @param decodeString
	 * @param ctype
	 * @return
	 */
	public static <T> T mapObjectToType(String jsonString, boolean decodeString, Class<T> ctype) {

		T type = null;

		try {
			if (decodeString) {
				jsonString = URLDecoder.decode(jsonString, Constants.ENCODING_UTF_8);
			}

			ObjectMapper mapper = new ObjectMapper();
			type = mapper.readValue(jsonString, ctype);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return type;
	}

}
