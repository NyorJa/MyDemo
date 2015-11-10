/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xdc.bootcamp.boot.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xdc.bootcamp.boot.entity.User;

/**
 *
 * @author rodfetalveroiii
 */
public interface UserDao extends GenericDAO<User>{
	public List<Object[]> getDefinedList(HttpServletRequest request) throws IllegalArgumentException;
	public User findByUsername(String username);
}
