package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.controller.CateController;
import com.kh.model.vo.Category;

public class CateInput {
	private CateController cc = new CateController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		cc.loadList();
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 값 저장");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				addList();
				break;
			case 2:
				selectList();
				break;
			case 3:
				cc.saveList();
				System.out.println("값이 저장되었습니다!");
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void addList() {
		System.out.println("----재료 카테고리----");
	
		System.out.print("음식이름 : ");
		String fName = sc.nextLine();
		
		System.out.print("음식 이미지 경로 : ");
		String fImagePath = sc.nextLine();
		
		System.out.print("음식 양(인분) : ");
		String amount = sc.nextLine();
		
		System.out.print("조리 시간 : ");
		String time = sc.nextLine();
		
		System.out.print("재료 넣을 개수 입력 : ");
		int ingreCount = sc.nextInt();
		sc.nextLine();
		String[] ingre = new String[ingreCount];
		for(int i = 0; i < ingreCount; i++) {
			System.out.print("재료 : ");
			ingre[i] = sc.nextLine();
		}
		
		System.out.print("레시피 순서 개수 입력 :");
		int recipeCount = sc.nextInt();
		sc.nextLine();
		String[] recipe = new String[recipeCount];
		for(int j = 0; j < recipeCount; j++) {
			System.out.print("레시피 : ");
			recipe[j] = sc.nextLine();
		}
		Category category = new Category(fName, fImagePath, amount, time, ingre, recipe);
		cc.addCateList(category);	
	}

	public void selectList() {
		System.out.println("-------- 전체 조회 --------");
		ArrayList<Category> list = cc.selectList();
		
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else {
			System.out.println("목록이 존재하지 않습니다.");
		}
	}
}
