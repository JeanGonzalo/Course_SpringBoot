package com.example.core.model;

public class Languages {
	
	private int id;
	private String title;
	private String description;
	private String linkImg;
	
	public Languages(int id, String title, String description, String linkImg) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.linkImg = linkImg;
	}

	public Languages() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	
	
	
	

}
