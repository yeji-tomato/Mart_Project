package com.kh.model.vo;

public class User {
	private String name;
	private int age;
	private String pwd;
	private int paypwd;
	private String address;
	private int cardNum;
	public User() {
		
	}
	public User(String name, int age, String pwd, int paypwd, String address, int cardNum) {
		super();
		this.name = name;
		this.age = age;
		this.pwd = pwd;
		this.paypwd = paypwd;
		this.address = address;
		this.cardNum = cardNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPaypwd() {
		return paypwd;
	}
	public void setPaypwd(int paypwd) {
		this.paypwd = paypwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", pwd=" + pwd + ", paypwd=" + paypwd + ", address=" + address
				+ ", cardNum=" + cardNum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + cardNum;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + paypwd;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (cardNum != other.cardNum)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paypwd != other.paypwd)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
	

}
