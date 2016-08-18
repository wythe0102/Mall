package com.wythe.mall.adapter;

public class Type {
	private String typeName;
	private int id;
	private int icon;

	public Type(int id, int icon, String typeName) {
		super();
		this.typeName = typeName;
		this.id = id;
		this.icon = icon;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
