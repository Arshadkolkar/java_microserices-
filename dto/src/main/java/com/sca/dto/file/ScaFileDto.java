package com.sca.dto.file;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.sca.dao.domain.file.ScaFile;

public class ScaFileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fileId;
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private Long fileSize;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ScaFile convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ScaFile.class);
	}
}
