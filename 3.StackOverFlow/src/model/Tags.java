package model;

import java.util.UUID;

public class Tags {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Tags(String name) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tags [id=" + id + ", name=" + name + "]";
	}
	
	

}
