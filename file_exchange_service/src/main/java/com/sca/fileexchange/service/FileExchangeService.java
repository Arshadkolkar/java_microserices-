package com.sca.fileexchange.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sca.common.response.ValidationResponse;
import com.sca.dto.file.ScaFileDto;

public interface FileExchangeService {
	ValidationResponse uploadFile(MultipartFile file, String accessToken) throws IOException;

	List<ScaFileDto> getFiles();

}
