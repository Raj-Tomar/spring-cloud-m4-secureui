package com.example;

public class TollUsage {

	private String id;
	private String stationId;
	private String licensePlate;
	private String timestamp;

	public TollUsage() {
	}

	public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
		super();
		this.id = id;
		this.stationId = stationId;
		this.licensePlate = licensePlate;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
