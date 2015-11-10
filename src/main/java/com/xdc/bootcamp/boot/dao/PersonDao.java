package com.xdc.bootcamp.boot.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xdc.bootcamp.boot.entity.Person;

public interface PersonDao extends GenericDAO<Person> {
	public List<Object[]> getDefined(HttpServletRequest request) throws IllegalArgumentException;
}
