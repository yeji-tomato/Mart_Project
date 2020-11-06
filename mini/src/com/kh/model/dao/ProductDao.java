package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {
	public ArrayList<Product>openMemberListFile(){
		ArrayList<Product>list = new ArrayList<>();
		
		list.add(new Product("±èÄ¡¶ó¸é",1500,5,"image/±èÄ¡¶ó¸é.jpeg",false));
		list.add(new Product("¸ÆÁÖ",2500,5,"image/¸ÆÁÖ.jpeg",true));
		return list;
		
	}
}
