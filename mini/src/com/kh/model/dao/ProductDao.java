package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {
	public ArrayList<Product>openMemberListFile(){
		ArrayList<Product>list = new ArrayList<>();
		
		list.add(new Product("김치라면",1500,5,"image/김치라면.jpeg",false));
		list.add(new Product("맥주",2500,5,"image/맥주.jpeg",true));
		return list;
		
	}
}
