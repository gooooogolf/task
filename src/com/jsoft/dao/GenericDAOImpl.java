package com.jsoft.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDAOImpl<Clazz> implements GenericDAO<Clazz> {

	@Autowired
    public SessionFactory sessionFactory;
	
	private Class<Clazz> clazz;

	protected Class<Clazz> getType() {
		return this.clazz;
	}

	protected String getClassName() {
		return clazz.getName();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		clazz = (Class) pt.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public Clazz find(Integer id) {
		// TODO Auto-generated method stub
		return (Clazz) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public void save(Clazz clazz) {
		sessionFactory.getCurrentSession().save(clazz);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clazz> findAll() {
		String hql = "from " + clazz.getName();
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public Integer countAll() {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
//		criteria.setProjection(Projections.rowCount());	
//		return (Integer) criteria.uniqueResult();
		String hql = "from " + clazz.getName();
		return sessionFactory.getCurrentSession().createQuery(hql).list().size();
	}

	@Override
	public void delete(Clazz clazz) {
		sessionFactory.getCurrentSession().delete(clazz);

	}

	@Override
	public void update(Clazz clazz) {
		sessionFactory.getCurrentSession().update(clazz);
		
	}

	@Override
	public void saveOrUpdate(Clazz clazz) {
//		System.out.println(clazz);
		sessionFactory.getCurrentSession().saveOrUpdate(clazz);
		
	}

}
