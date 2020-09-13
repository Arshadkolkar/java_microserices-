/**
 * 
 */
package com.sca.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
// prefix fileservice, find fileservice.* values
@ConfigurationProperties("fileservice")
public class FileServiceProperties {

	private String basePath;
	private String rootFolder;
	private String fileExchangeFolder;
	private String fileExchangeFolderPrefix;

	/**
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	/**
	 * @return the rootFolder
	 */
	public String getRootFolder() {
		return rootFolder;
	}

	/**
	 * @param rootFolder the rootFolder to set
	 */
	public void setRootFolder(String rootFolder) {
		this.rootFolder = rootFolder;
	}

	/**
	 * 
	 * @return
	 */
	public String getFileExchangeFolder() {
		return fileExchangeFolder;
	}

	/**
	 * 
	 * @param fileExchangeFolder
	 */
	public void setFileExchangeFolder(String fileExchangeFolder) {
		this.fileExchangeFolder = fileExchangeFolder;
	}

	/**
	 * 
	 * @return
	 */
	public String getFileExchangeFolderPrefix() {
		return fileExchangeFolderPrefix;
	}

	/**
	 * 
	 * @param fileExchangeFolderPrefix
	 */
	public void setFileExchangeFolderPrefix(String fileExchangeFolderPrefix) {
		this.fileExchangeFolderPrefix = fileExchangeFolderPrefix;
	}

}
