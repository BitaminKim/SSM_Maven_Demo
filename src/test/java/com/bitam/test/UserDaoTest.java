package com.bitam.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitam.dao.UserMapper;
import com.bitam.pojo.User;

public class UserDaoTest extends BaseTest {

	@Autowired
	UserMapper userMapper;
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername("bbbbb");
		user.setPassword("aaaaaaa");
		user.setAge(14);
		user.setSex("Famale");
		System.out.println("共插入"+userMapper.insertUser(user)+"条数据");
	}
}
