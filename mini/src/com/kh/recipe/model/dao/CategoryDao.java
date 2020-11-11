package com.kh.recipe.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.recipe.model.vo.Category;

public class CategoryDao {
	
	public ArrayList<Category> fileOpen(){
		
		ArrayList<Category>  cateList = new ArrayList<>();
		
		try(ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("file/category.txt"))){
			cateList = (ArrayList<Category>)ois.readObject();
		
		} catch (IOException e) {
			System.out.println("category.txt 파일을 로드하지 못했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<Categoty>으로 캐스팅 할 수 없습니다.");
		}
		return cateList;
	}
	
	public void fileSave(ArrayList<Category> CateList) {
//		ArrayList<Category>  cateList = new ArrayList<>();
//		String[] indi = {"삼겹살", "대파", "청양고추", "고추장", "김치", "홍고추", "사골곰탕"};
//		cateList.add(new Category("삼겹살김치말이찜", "image/recipe/category/삼겹살김치말이찜.jpg", indi, "레시피"));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file/category.txt"))){
			oos.writeObject(CateList);
		} catch (IOException e) {
			System.out.println("category.txt 파일 저장에 실패하였습니다.");
		}
	}
	

}
