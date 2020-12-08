package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.model.vo.User;

public class UserDao {

//	private ArrayList<User> userList = new ArrayList<>();

	/*{
		userList.add(new User("권세희", 25, "ii1425", "tpals0322@", "0322", "수원시 팔달구 우만동", 1234));
	}*/


	// 값 오픈
	public ArrayList<User> openUserListFile() {

		ArrayList<User> list = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userList.dat"))) {

			list = (ArrayList<User>) ois.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("userList.dat 파일을 로드하지 못했습니다.");
		} catch (IOException e) {
			System.out.println("userList.dat 파일을 로드하지 못했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<User>으로 캐스팅 할 수 없습니다.");
		}

		return list;

	}
	
	// 값 저장
		public void saveUserListFile(ArrayList<User> list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//로그인 된 회원 정보
		public void saveLoginListFile(User list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loginList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//로그인 정보 가져오기public ArrayList<User> openUserListFile() {
		public User openLoginFile() {
		User loginUser = new User();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("loginList.dat"))) {

			loginUser = (User) ois.readObject();

		} /*catch (FileNotFoundException e) {
			System.out.println("userList.dat 파일을 로드하지 못했습니다.");
		} */catch (IOException e) {
			System.out.println("loginList.dat 파일을 로드하지 못했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<User>으로 캐스팅 할 수 없습니다.");
		}

		return loginUser;

	}
		//로그아웃
		public void logoutFile(User list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loginList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
