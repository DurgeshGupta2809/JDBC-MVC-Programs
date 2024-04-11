package com.ty.userapplication.dto;

import com.ty.userapplication.dao.FetchDao;
import com.ty.userapplication.dao.UserDao;
import com.ty.userapplication.entity.User;

public class UserDto {

//	public static String insertUser(User user) {
//		return UserDao.insertUser(user);
//	}
	
//	public static void fetchUserById(int id) {
//		UserDao.fetchUserById(id);
//	}
	
//	public static String deleteUser(int id) {
//		return UserDao.deleteUser(id);
//	}
	
	public static String updateUser(int id,String name,String email,long phone,String password) {
		return UserDao.updateUser(id,name,email,phone,password);
		
	}
}
