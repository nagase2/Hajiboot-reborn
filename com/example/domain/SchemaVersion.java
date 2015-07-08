package com.example.domain;

// Generated 2015/07/08 11:31:23 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * SchemaVersion generated by hbm2java
 */
public class SchemaVersion implements java.io.Serializable {

	private String version;
	private int versionRank;
	private int installedRank;
	private String description;
	private String type;
	private String script;
	private Integer checksum;
	private String installedBy;
	private Date installedOn;
	private int executionTime;
	private boolean success;

	public SchemaVersion() {
	}

	public SchemaVersion(String version, int versionRank, int installedRank,
			String description, String type, String script, String installedBy,
			Date installedOn, int executionTime, boolean success) {
		this.version = version;
		this.versionRank = versionRank;
		this.installedRank = installedRank;
		this.description = description;
		this.type = type;
		this.script = script;
		this.installedBy = installedBy;
		this.installedOn = installedOn;
		this.executionTime = executionTime;
		this.success = success;
	}

	public SchemaVersion(String version, int versionRank, int installedRank,
			String description, String type, String script, Integer checksum,
			String installedBy, Date installedOn, int executionTime,
			boolean success) {
		this.version = version;
		this.versionRank = versionRank;
		this.installedRank = installedRank;
		this.description = description;
		this.type = type;
		this.script = script;
		this.checksum = checksum;
		this.installedBy = installedBy;
		this.installedOn = installedOn;
		this.executionTime = executionTime;
		this.success = success;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getVersionRank() {
		return this.versionRank;
	}

	public void setVersionRank(int versionRank) {
		this.versionRank = versionRank;
	}

	public int getInstalledRank() {
		return this.installedRank;
	}

	public void setInstalledRank(int installedRank) {
		this.installedRank = installedRank;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public Integer getChecksum() {
		return this.checksum;
	}

	public void setChecksum(Integer checksum) {
		this.checksum = checksum;
	}

	public String getInstalledBy() {
		return this.installedBy;
	}

	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}

	public Date getInstalledOn() {
		return this.installedOn;
	}

	public void setInstalledOn(Date installedOn) {
		this.installedOn = installedOn;
	}

	public int getExecutionTime() {
		return this.executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}