package com.sca.dto.common;

public class ProjectDetailDto {
	private String projectName;
	private String finishLevelName;
	private String finishLevelGradeName;
	private Long initialMarketValue = 0L;

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the finishLevelName
	 */
	public String getFinishLevelName() {
		return finishLevelName;
	}

	/**
	 * @param finishLevelName the finishLevelName to set
	 */
	public void setFinishLevelName(String finishLevelName) {
		this.finishLevelName = finishLevelName;
	}

	/**
	 * @return the finishLevelGradeName
	 */
	public String getFinishLevelGradeName() {
		return finishLevelGradeName;
	}

	/**
	 * @param finishLevelGradeName the finishLevelGradeName to set
	 */
	public void setFinishLevelGradeName(String finishLevelGradeName) {
		this.finishLevelGradeName = finishLevelGradeName;
	}

	/**
	 * @return the initialMarketValue
	 */
	public Long getInitialMarketValue() {
		return initialMarketValue;
	}

	/**
	 * @param initialMarketValue the initialMarketValue to set
	 */
	public void setInitialMarketValue(Long initialMarketValue) {
		this.initialMarketValue = initialMarketValue;
	}

}