package com.kh.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1811378904658844019L;
	private String fName;
	private String fImagePath;
	private String amount;
	private String time;
	private String ingre[];
	private String recipe[];
	
	public Category() {}

	public Category(String fName, String fImagePath, String amount, String time, String[] ingre, String[] recipe) {
		super();
		this.fName = fName;
		this.fImagePath = fImagePath;
		this.amount = amount;
		this.time = time;
		this.ingre = ingre;
		this.recipe = recipe;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfImagePath() {
		return fImagePath;
	}

	public void setfImagePath(String fImagePath) {
		this.fImagePath = fImagePath;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String[] getIngre() {
		return ingre;
	}

	public void setIngre(String[] ingre) {
		this.ingre = ingre;
	}

	public String[] getRecipe() {
		return recipe;
	}

	public void setRecipe(String[] recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Category [fName=" + fName + ", fImagePath=" + fImagePath + ", amount=" + amount + ", time=" + time
				+ ", ingre=" + Arrays.toString(ingre) + ", recipe=" + Arrays.toString(recipe) + "]";
	}

	
	
	
	
}
