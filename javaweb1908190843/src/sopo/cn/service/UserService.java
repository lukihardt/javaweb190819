package sopo.cn.service;

import sopo.cn.model.User;

/**
 * this class is modified to servlet for cookie demo
 * @author Administrator
 *
 */

public class UserService{
	String ausername = "OoyizhioO";
	String apassword = "8181006";

	public User login(String username, String password) {
		if(username.equals(ausername) && password.equals(apassword)) {
			System.out.println("��ʱ�൱�ڲ�ѯ�����ݿ�");
			User user = new User( username, password);
			return user;
		}else {
			return null;
		}
	}
}
