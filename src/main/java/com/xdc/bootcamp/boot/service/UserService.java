/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xdc.bootcamp.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xdc.bootcamp.boot.dao.UserDao;
import com.xdc.bootcamp.boot.entity.User;
import com.xdc.bootcamp.boot.model.UserInfo;

/**
 *
 * @author rodfetalveroiii
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public User add(User user){
        return userDao.add(user);
    }
    
    public User get(int id){
        return userDao.get(id);
    }
    
    public User update(User user){
        return userDao.update(user);
    }
    
    public List<User> getAll(HttpServletRequest request){
        return userDao.getAll(request);
    }
    
    public Long getTotal(HttpServletRequest request){
        return userDao.getCount(request);
    }
    
    public List<UserInfo> getDefinedList(HttpServletRequest request){
    	List<UserInfo> userInfos = new ArrayList<>();
    	List<Object[]> results = userDao.getDefinedList(request);
    	for (Object[] res : results) {
    		UserInfo userInfo = new UserInfo();
    		userInfo.setUserId((Integer) res[0]);
    		userInfo.setPersonId((Integer) res[1]);
    		userInfo.setUsername((String) res[2]);
    		userInfo.setPassword((String) res[3]);
    		userInfos.add(userInfo);
		}
    	return userInfos;
    }
    
    public User findByUsername(String username){
    	return userDao.findByUsername(username);
    }
}
