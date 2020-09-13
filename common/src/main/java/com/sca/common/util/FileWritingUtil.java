/**
 * 
 */
package com.sca.common.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
public class FileWritingUtil {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger("FileWritingUtil");

	/**
	 * 
	 * @param directoryName
	 * @param fileInternalName
	 * @param csvFileHeader
	 * @param dataList
	 */
	public static void writeCsvFile(String directoryName, String fileInternalName, String csvFileHeader,
			List<Map<String, Object>> dataList) {
		FileWriter fileWriter = null;
		long start = 0L;
		try {
			File directory = new File(directoryName);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			File file = new File(directoryName + fileInternalName);
			start = System.currentTimeMillis();
			fileWriter = new FileWriter(file.getAbsolutePath());

			// Write the CSV file header
			fileWriter.append(csvFileHeader);

			// Add a new line separator after the header
			fileWriter.append(Constants.NEW_LINE_SEPARATOR);

			// Write data list to the CSV file
			for (Map<String, Object> dataMap : dataList) {
				String dataRow = dataMap.entrySet().stream()
						.map(e -> e.getValue() == null ? "NULL" : e.getValue().toString())
						.collect(Collectors.joining(Constants.COMMA_DELIMITER));

				fileWriter.append(dataRow);
				fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			}
		} catch (Exception e) {
			logger.error("Error in creating csv file:" + e.getMessage());
		} finally {
			try {
				fileWriter.flush();
				long end = System.currentTimeMillis();
				logger.info("File has been created successfully: " + (end - start) / 1000f + " seconds");
				fileWriter.close();
			} catch (IOException e) {
				logger.error("Error while flushing/closing fileWriter:" + e.getMessage());
			}
		}

	}

}
