/**
 * 
 */
package com.sca.common.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author subhash
 *
 */
public class JsonUtil {

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static String marshal(Object object) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(object);
	}

	/**
	 * 
	 * @param object
	 * @param jtype
	 * @return
	 */
	public static String marshal(Object object, Type jtype) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(object, jtype);
	}

	/**
	 * 
	 * @param <T>
	 * @param jsonStr
	 * @param jtype
	 * @return
	 */
	public static <T> T unmarshal(String jsonStr, Class<T> jtype) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.fromJson(jsonStr, jtype);
	}

	/**
	 * 
	 * @param <T>
	 * @param object
	 * @param jtype
	 * @return
	 * @throws IOException
	 */
	public static <T> T unmarshal(Object object, Class<T> jtype) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.setTimeZone(TimeZone.getTimeZone("UTC"));
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"));
		byte[] json = mapper.writeValueAsBytes(object);

		return mapper.readValue(json, jtype);
	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	public static String jsonEncode(Map<String, String> map) {
		Gson gson = new Gson();
		return gson.toJson(map);
	}

}
