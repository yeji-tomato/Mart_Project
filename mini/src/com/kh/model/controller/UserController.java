package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

public class UserController {
	private UserDao ud = new UserDao();
	public ArrayList<User>getUserList(){
		return ud.openUserListFile();
	}
}
