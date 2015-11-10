package com.xdc.bootcamp.boot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.xdc.bootcamp.boot.dao.PersonDao;
import com.xdc.bootcamp.boot.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Person add(Person entity) throws IllegalArgumentException {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Person get(Object key) throws IllegalArgumentException {
		return entityManager.find(Person.class, key);
	}

	@Override
	public Person update(Person entity) throws IllegalArgumentException {
		return entityManager.merge(entity);
	}

	@Override
	public boolean remove(Object key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Person> getAll() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAll(HttpServletRequest request) throws IllegalArgumentException {
		Query query = entityManager.createQuery("select p from Person p order by p.id desc");
		return query.getResultList();
	}

	@Override
	public boolean exists(Person entity) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String generateDocNo(Integer entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCount(HttpServletRequest request) {
		Query query = entityManager.createQuery("select count(*) from Person p");
		return (Long)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getDefined(HttpServletRequest request) throws IllegalArgumentException {
		Query query = entityManager.createQuery("select "
				+ " p.id, "
				+ " p.name, "
				+ " p.age "
				+ " from Person p "
				+ " order by p.id desc ");
		return query.getResultList();
	}

}
