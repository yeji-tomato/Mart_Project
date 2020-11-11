package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

public class UserController {
	private UserDao ud = new UserDao();
	//
	private ArrayList<User> list = new ArrayList<>();
	
	/*public ArrayList<User>getUserList(){
		ud.saveUserListFile();
		return ud.openUserListFile();
	}*/
	
	// 리스트 안에 넣기
	public void addList(User user) {
		list.add(user);
	}
	
	
	// 열기
	public ArrayList<User> openList() {
		list = ud.openUserListFile();
		return list;
	}
	// 저장
	public void saveList() {
		ud.saveUserListFile(list);
	}
}
