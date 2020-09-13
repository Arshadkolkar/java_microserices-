/**
 * 
 */
package com.sca.common.util;

import java.io.IOException;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
public class GeoCodeUtil {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(GeoCodeUtil.class);

	/**
	 * 
	 * @param googleMapKey
	 * @param homeLatitude
	 * @param homeLongitude
	 * @return
	 */
	public static String getCityByGoogleGeoCodeValues(String googleMapKey, String homeLatitude, String homeLongitude) {
		String city = "";

		try {
			GeoApiContext context = new GeoApiContext.Builder().apiKey(googleMapKey).build();
			GeocodingResult[] results = GeocodingApi.newRequest(context)
					.latlng(new LatLng(Double.valueOf(homeLatitude), Double.valueOf(homeLongitude))).await();
			if (results == null || results.length <= 0) {
				return city;
			}
			GeocodingResult result = results[0];

			for (AddressComponent component : result.addressComponents) {
				AddressComponentType[] types = component.types;
				if (types[0] == AddressComponentType.LOCALITY && types[1] == AddressComponentType.POLITICAL) {
					city = component.longName;
					break;
				} else if (types[0] == AddressComponentType.POLITICAL && types[1] == AddressComponentType.SUBLOCALITY) {
					city = component.longName;
					break;
				} else if (types[0] == AddressComponentType.POLITICAL
						&& types[1] == AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_3) {
					city = component.longName;
					break;
				}
			}

		} catch (ApiException | InterruptedException | IOException e) {
			logger.error("Error while getCityByGoogleGeoCodeValues: " + e.getMessage(), e);
		}

		return city;
	}

}
