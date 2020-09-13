/**
 * 
 */
package com.sca.common.util;

import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
public class CsvDataLoader {
	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(CsvDataLoader.class);

	public static <T> List<T> loadObjectList(Class<T> type, String fileName) {

		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();
			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema)
					.readValues(new ClassPathResource(fileName).getInputStream());
			return readValues.readAll();
		} catch (Exception e) {
			logger.error("Error occurred while loading object list from file " + fileName, e);
			return Collections.emptyList();
		}
	}
}
