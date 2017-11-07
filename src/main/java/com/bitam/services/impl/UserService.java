package com.bitam.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitam.dao.UserMapper;
import com.bitam.pojo.User;
import com.bitam.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserById(user);
	}

	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return userMapper.selectUserCount();
	}

	@Override
	public List<User> selectUserAll() {
		// TODO Auto-generated method stub
		return userMapper.selectUserAll();
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}

}
