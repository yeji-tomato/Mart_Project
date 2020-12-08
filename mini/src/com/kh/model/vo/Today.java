package com.kh.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Today implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6620536133436871210L;
	private String cook[];
	private String imagePath;
	
	public Today() {}
	
	public Today(String[] cook, String imagePath) {
		super();
		this.cook = cook;
		this.imagePath = imagePath;
	}

	public String[] getCook() {
		return cook;
	}

	public void setCook(String[] cook) {
		this.cook = cook;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Today [cook=" + Arrays.toString(cook) + ", imagePath=" + imagePath + "]";
	}
	
	
	
	
	
	

}
