/**
 * 
 */
package com.sca.fileexchange.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.response.ValidationResponse;
import com.sca.common.util.FileUploadUtil;
import com.sca.dto.file.ScaFileDto;
import com.sca.fileexchange.service.FileExchangeService;
import com.sca.fileexchange.util.Constants;

/**
 * 
 * @author shajeer
 *
 */

@RestController
@RequestMapping(Constants.FILE_EXCHANGE_REST_URL)
public class FileExchangeController {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(FileExchangeController.class);

	@Autowired
	private ExceptionUtil exceptionUtil;

	@Autowired
	private FileExchangeService fileExchangeService;

	@GetMapping
	public ResponseEntity<ValidationResponse> getIpAuditLog(
			@RequestHeader(value = "access-token", required = true) String accessToken) throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			logger.debug("file exchange controller started");
			List<ScaFileDto> scaFiles = fileExchangeService.getFiles();
			response.setMessage(scaFiles);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the IpAuditLog ");
		}

		return ResponseEntity.ok(response);
	}

	@PostMapping()
	public ResponseEntity<ValidationResponse> uploadfile(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam("file") MultipartFile file) throws GenericException {
		ValidationResponse response = new ValidationResponse();

		try {
			FileUploadUtil.isValidFile(file,
					Arrays.asList("image/gif", "image/jpg", "image/jpeg", "image/png", "application/pdf",
							"application/vnd.openxmlformats-officedocument.wordprocessingml.document",
							"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
							"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/msword",
							"application/vnd.ms-excel", "application/octet-stream", "application/vnd.msexcel",
							"application/excel"),
					5);
			fileExchangeService.uploadFile(file, accessToken);

			response.setMessage("file uploaded");
		} catch (Exception exception) {
			logger.error("Error while updating property attachment: {}", exception.getMessage());
			exceptionUtil.processException(exception, "Failed to update property attachment ");
		}

		return ResponseEntity.ok(response);
	}

}
