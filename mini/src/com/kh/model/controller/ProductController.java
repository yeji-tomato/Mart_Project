package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductController {
	private ProductDao pd = new ProductDao();
	public ArrayList<Product>getProductList(){
		return pd.openMemberListFile();
	}
}
