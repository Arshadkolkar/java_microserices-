/**
 * 
 */
package com.sca.fileexchange.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.properties.FileServiceProperties;
import com.sca.common.response.ValidationResponse;
import com.sca.dao.domain.file.ScaFile;
import com.sca.dao.repository.file.ScaFileRepository;
import com.sca.dto.file.ScaFileDto;
import com.sca.fileexchange.service.FileExchangeService;

@Service
@Transactional
public class FileExchangeServiceImpl extends FileExchangeCommonService implements FileExchangeService {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(FileExchangeServiceImpl.class);

	@Autowired
	private FileServiceProperties fileServiceProperties;

	@Autowired
	private ScaFileRepository scaFileRepository;

	@Override
	public ValidationResponse uploadFile(MultipartFile file, String accessToken) throws IOException {
		String uploadDirectory = getFileExchangeUploadsFolder((long) 1);
		logger.debug("folderToUpload" + uploadDirectory);
		String fileName = uploadFile(uploadDirectory, file);
		logger.debug("fileName:" + fileName);

		ScaFile scaFile = new ScaFile();
		scaFile.setFileName(file.getOriginalFilename());
		scaFile.setFileSize(file.getSize());
		scaFile.setFileType(file.getContentType());
		scaFile.setFileDownloadUri(fileName);
		scaFileRepository.save(scaFile);
		return null;
	}

	private String getFileExchangeUploadsFolder(Long userPropertyId) {
		StringBuilder uploadDirectory = new StringBuilder(fileServiceProperties.getRootFolder());
		uploadDirectory.append(fileServiceProperties.getFileExchangeFolder());
		uploadDirectory.append(fileServiceProperties.getFileExchangeFolderPrefix());
		uploadDirectory.append(userPropertyId.toString());

		return uploadDirectory.toString();
	}

	public String downloadFile(String fileName, Long userPropertyId) {
		StringBuilder imagePath = new StringBuilder(fileServiceProperties.getBasePath());
		imagePath.append(fileServiceProperties.getFileExchangeFolder());
		imagePath.append(fileServiceProperties.getFileExchangeFolderPrefix());
		imagePath.append(userPropertyId.toString());
		imagePath.append(File.separatorChar);
		imagePath.append(fileName);

		return imagePath.toString();
	}

	@Override
	public List<ScaFileDto> getFiles() {
		List<ScaFile> scaFiles = scaFileRepository.findAll();
		List<ScaFileDto> scaFilesDto = new ArrayList<>();
		ScaFileDto scaFileDto = null;
		for (ScaFile scaFile : scaFiles) {
			scaFileDto = new ScaFileDto();
			String downloadPath = downloadFile(scaFile.getFileDownloadUri(), 1L);
			scaFileDto.setFileDownloadUri(downloadPath);
			scaFileDto.setFileName(scaFile.getFileName());
			scaFileDto.setFileType(scaFile.getFileType());
			scaFileDto.setFileSize(scaFile.getFileSize());
			scaFilesDto.add(scaFileDto);
		}
		return scaFilesDto;
	}

}
