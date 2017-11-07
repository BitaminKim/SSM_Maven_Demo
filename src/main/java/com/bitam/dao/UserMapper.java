package com.bitam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitam.pojo.User;

public interface UserMapper {

	int insertUser(User user);

	int deleteUserById(int id);

	int updateUserById(@Param("user") User user);

	int selectUserCount();

	List<User> selectUserAll();

	User selectUserById(int id);
}
