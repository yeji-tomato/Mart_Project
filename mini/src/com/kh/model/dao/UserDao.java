package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.User;

public class UserDao {
	public ArrayList<User>openUserListFile(){
		ArrayList<User>list = new ArrayList<>();
		
		list.add(new User("권세희",25,"tpals0322@",0322,"수원시 팔달구 우만동",1234));
		return list;
		
	}
}
