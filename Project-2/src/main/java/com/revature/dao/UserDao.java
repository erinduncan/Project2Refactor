package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.driver.Log;
import com.revature.models.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sesf;
	
	@Autowired
	public UserDao(SessionFactory sesf) {
		super();
		this.sesf = sesf;
	}
	

//	@Override
	public List<User> findAll() {
		List<User> list;
		try {
			list = sesf.getCurrentSession().createQuery("from User", User.class).list();
			Log.log.info("All users found and returned.");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error(e);
			System.out.println("ERROR! Could not findAll");
		}
		return null;
	}

//	@Override
	public User findById(int id) {
		User user;
		try {
			user = sesf.getCurrentSession().get(User.class, id);
			Log.log.info("User found by ID number.");
			return user;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not findbyid "+id);
		}
		return null;
	}

//	@Override
	public User update(User t) {
		try {
			sesf.getCurrentSession().update(t);
			return t;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not update \n"+t.toString());
		}
		return null;
	}

//	@Override
	public User insert(User t) {
		try {
			sesf.openSession().save(t);
			Log.log.info("New user created.");
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not save \n"+t.toString());
		}
		return t;
	}

//	@Override
	public User deleteByEmail(String email) {
		try {
			User t = findByEmail(email);
			sesf.getCurrentSession().delete(t);
			return t;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not Deletebyemail "+email);
		}
		return null;
	}

//	@Override
	public User findByEmail(String email) {
		try {
			@SuppressWarnings("deprecation")
			Criteria criteria = sesf.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.like("email", email));
			return (User) criteria.list().get(0);
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not findbyemail "+email);
		}
		return null;
	}

}