package com.infybuzz.flux.support;

public class Item {
	private Long id;
	private String itemname;

	public Item(Long id, String itemname) {
		this.id = id;
		this.itemname = itemname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

}
