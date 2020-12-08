package com.kh.model.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.kh.model.dao.CategoryDao;
import com.kh.model.vo.Category;

public class CateController{
	private CategoryDao cd = new CategoryDao();
	private ArrayList<Category> list = new ArrayList<>();
	
	public ArrayList<Category> getCateList(){
		return cd.fileOpen();
	}
	
	public void addCateList(Category category) {
		list.add(category);
	}
	
	public ArrayList<Category> selectList(){
		return list;
	}
	
	public ArrayList<Category> searchTitle(String title){
		ArrayList<Category> search = new ArrayList<Category>();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getfName().equals(title)) {
				search.add(list.get(i));
			}
		}
		
		return search;
		
	}

	public void loadList() {
		list = cd.fileOpen();
	}

	public void saveList() {
		cd.fileSave(list);
	}




}
