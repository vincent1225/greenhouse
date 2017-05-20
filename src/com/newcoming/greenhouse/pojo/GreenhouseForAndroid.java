package com.newcoming.greenhouse.pojo;

public class GreenhouseForAndroid {
	private Long id;
	private String greenhouseId;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGreenhouseId() {
		return greenhouseId;
	}

	public void setGreenhouseId(String greenhouseId) {
		this.greenhouseId = greenhouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GreenhouseForAndroid(Long id, String greenhouseId, String name) {
		super();
		this.id = id;
		this.greenhouseId = greenhouseId;
		this.name = name;
	}

	public GreenhouseForAndroid() {
	}

}
