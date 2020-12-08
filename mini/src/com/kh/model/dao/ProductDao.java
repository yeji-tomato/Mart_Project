package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {

  
   public ArrayList<Product>openProductListFile(){
	      

	      ArrayList<Product>productList = new ArrayList<>();
	      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productList.dat"))){
	   
	         productList = (ArrayList<Product>) ois.readObject();
	         
	      } catch (FileNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   
	      return productList;
	      
	   }
   
   public void saveProductListFile(ArrayList<Product> productList){
	 //이건처음에 상품 리스트 넣어줄때
	 /*  ArrayList<Product>productList = new ArrayList<>();
	   {
		      productList.add(new Product("맥주",2500,5,"image/맥주.png",true));
		      productList.add(new Product("김치라면",1500,5,"image/김치라면.png",false));
		      productList.add(new Product("고등어조림",3500,5,"image/고등어조림.png",false));
		      productList.add(new Product("소주",1500,5,"image/소주.png",true));
		      productList.add(new Product("막걸리",2000,5,"image/막걸리.png",true));
		      productList.add(new Product("꼬북칩",1500,5,"image/꼬북칩.png",false));
		      productList.add(new Product("수미칩",3000,5,"image/수미칩.png",false));
		      productList.add(new Product("햇반",1700,5,"image/햇반.png",false));
		      productList.add(new Product("당근",700,5,"image/당근.png",false));
		      productList.add(new Product("돼지고기",6000,5,"image/돼지고기.png",false));
		   }*/
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productList.dat"))){

         oos.writeObject(productList);
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
      
   }
   //장바구니에 담을 리스트 넣는 메소드
   public void saveBasketList(ArrayList<Product> p){
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basketList.dat"))){

         oos.writeObject(p);
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
      
   }
   
   
   public ArrayList<Product>openBasketListFile(){
      

      ArrayList<Product>list = new ArrayList<>();
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("basketList.dat"))){
   
         list = (ArrayList<Product>) ois.readObject();
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
      return list;
      
   }
}