package com.xdc.bootcamp.boot.service;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import com.xdc.bootcamp.boot.entity.Person;
import com.xdc.bootcamp.boot.model.PersonInfo;
import com.xdc.bootcamp.boot.dao.PersonDao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	PersonDao personDao;
	
	public Person add(Person person){
		return personDao.add(person);
	}
	
	public Person get(int id){
		return personDao.get(id);
	}
	
	public Person update(Person person){
		return personDao.update(person);
	}
	
	public List<Person> getAll(HttpServletRequest request){
		return personDao.getAll(request);
	}
	
	public Long getTotal(HttpServletRequest request){
		return personDao.getCount(request);
	}
	
	public List<PersonInfo> getDefinedList(HttpServletRequest request){
		List<Object[]> results = personDao.getDefined(request);
		List<PersonInfo> personInfos = new ArrayList<>();
		
		for (Object[] res : results) {
			PersonInfo personInfo = new PersonInfo();
			personInfo.setPersonId((Integer) res[0]);
			personInfo.setName((String) res[1]);
			personInfo.setAge((Integer) res[2]);
			personInfos.add(personInfo);
		}
		
		return personInfos;
	}
}
