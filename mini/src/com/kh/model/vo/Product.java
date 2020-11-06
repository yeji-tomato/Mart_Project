package com.kh.model.vo;

import java.io.Serializable;

public class Product implements Serializable{
	private String pName;
	private int price;
	private int cnt;
	private String img;
	private boolean adult;
	
	public Product() {
		
	}

	public Product(String pName, int price, int cnt, String img, boolean adult) {
		super();
		this.pName = pName;
		this.price = price;
		this.cnt = cnt;
		this.img = img;
		this.adult = adult;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", price=" + price + ", cnt=" + cnt + ", img=" + img + ", adult=" + adult
				+ "]";
	}

	
}
