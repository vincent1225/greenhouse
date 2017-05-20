package com.newcoming.greenhouse.pojo;

import java.util.List;

public class ParkForAndroid {
	private Long id;
	private String parkId;
	private String name;

	private List<GreenhouseForAndroid> greenhouses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GreenhouseForAndroid> getGreenhouses() {
		return greenhouses;
	}

	public void setGreenhouses(List<GreenhouseForAndroid> greenhouses) {
		this.greenhouses = greenhouses;
	}

	public ParkForAndroid(Long id, String parkId, String name,
			List<GreenhouseForAndroid> greenhouses) {
		super();
		this.id = id;
		this.parkId = parkId;
		this.name = name;
		this.greenhouses = greenhouses;
	}

	public ParkForAndroid() {
	}

}
