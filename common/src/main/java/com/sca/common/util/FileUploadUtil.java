/**
 * 
 */
package com.sca.common.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.UnprocessableEntityException;

/**
 * 
 * @author subhash
 *
 */
public class FileUploadUtil {

	public static boolean isValidFile(MultipartFile file, List<String> contentTypes, long maxSize) {

		if (file == null || file.isEmpty() || file.getSize() == 0) {
			throw new UnprocessableEntityException("Please select a file!");
		}

		if (!contentTypes.stream().anyMatch(contentType -> contentType.equals(file.getContentType().toLowerCase()))) {
			throw new UnprocessableEntityException("File type not allowed!");
			// throw new UnprocessableEntityException("File type not allowed,
			// only
			// png/jpeg image type are allowed.");
		}

		long MEGABYTE = 1024L * 1024L;
		long fileSize = file.getSize() / MEGABYTE;
		if (fileSize > maxSize) {
			throw new InvalidInputException("Files exceed " + maxSize + "mb, no upload allowed.");
		}

		return true;
	}
}
