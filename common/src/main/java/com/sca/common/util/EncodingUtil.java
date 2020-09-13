/**
 * 
 */
package com.sca.common.util;

/**
 * 
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
public class EncodingUtil {
	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(EncodingUtil.class);

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String urlEncode(String url) {
		try {
			return URLEncoder.encode(url, Constants.ENCODING_UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error("Error while encoding" + e.getMessage());
		}

		return url;
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String urlDecode(String url) {
		try {
			return URLDecoder.decode(url, Constants.ENCODING_UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error("Error while decoding" + e.getMessage());
		}

		return url;
	}

	/**
	 * 
	 * @param text
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Encode(String text) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(text.getBytes(Constants.ENCODING_UTF_8));
	}

}
