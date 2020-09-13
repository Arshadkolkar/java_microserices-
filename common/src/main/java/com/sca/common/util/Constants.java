/**
 * 
 */
package com.sca.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author subhash
 *
 */
public class Constants {

	public static final String COMMA_DELIMITER = ",";
	public static final String FWD_SLASH = "/";
	public static final String NEW_LINE_SEPARATOR = "\n";
	public static final String CSV_FILE_EXTENSION = ".csv";

	public static final String REGEX_EMAIL_FORMAT = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
			+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

	public static final String ENCODING_UTF_8 = "UTF-8";

	public static final String DATE_FORMAT_CALENDAR = "yyyy-MM-dd HH:mm:ss";

	// DEFAULT USER PASSWORD
	public static final String DEFAULT_USER_PASSWORD = "Welcome123";

	// HTTP HEADER NAMES
	public static final String HTTP_HEADER_ORGANIZATION_API_KEY = "organization-api-key";
	public static final String HTTP_HEADER_ACCESS_TOKEN = "access-token";
	public static final String HTTP_HEADER_ANONYMOUS_ACCESS_TOKEN = "anonymous-access-token";
	public static final String HTTP_HEADER_CLIENT_IP_ADDRESS = "client-ip-address";

	public static final List<Integer> nonWidgetApps = Arrays.asList(1, 2, 3, 4);

	public static final Long ORGANIZATION_ID_SCA = 1L;

}
