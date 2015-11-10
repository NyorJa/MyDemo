/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xdc.bootcamp.boot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.xdc.bootcamp.boot.dao.UserDao;
import com.xdc.bootcamp.boot.entity.User;

/**
 *
 * @author rodfetalveroiii
 */
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public User add(User entity) throws IllegalArgumentException {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public User get(Object key) throws IllegalArgumentException {
        return entityManager.find(User.class, key);
    }

    @Override
    public User update(User entity) throws IllegalArgumentException {
        return entityManager.merge(entity);
    }

    @Override
    public boolean remove(Object key) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll(HttpServletRequest request) throws IllegalArgumentException {
        Query query = entityManager.createQuery("select u from User u order by u.id desc");
        return query.getResultList();
    }

    @Override
    public boolean exists(User entity) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateDocNo(Integer entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getCount(HttpServletRequest request) {
        Query query = entityManager.createQuery("select count(*) from User u");
        return (Long) query.getSingleResult();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getDefinedList(HttpServletRequest request) throws IllegalArgumentException {
		Query query = entityManager.createQuery("select "
				+ " u.id,"
				+ " u.person.id, "
				+ " u.username,"
				+ " u.password"
				+ " from User u"
				+ " order by u.id desc ");
		return query.getResultList();
	}

	@Override
	public User findByUsername(String username) {
		
		/*
		Query query = entityManager.createQuery("select u from User u "
				+ " where u.username = :username ");
		query.setParameter("username", username);
		*/
		
		User user = null;
		
		try {
			user = (User) entityManager.createQuery("select u from User u "
					+ " where u.username = :username ").setParameter("username", username).
					setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			
		}
		
		return user;
		
	}
    
}
