package com.spring.template.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T>
		implements BasicOperations<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public T findOneById(long id) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		T newClazz = null;
		try {
			newClazz = session.get(super.klazz, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return (T) newClazz;
	}

	@Override
	public T findOneByKeyVal(String key, String value) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		T newClazz = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> cQuery = builder.createQuery(super.klazz);
			Root<T> root = cQuery.from(super.klazz);
			cQuery.select(root).where(builder.equal(root.get(key), value));
			Query<T> q = session.createQuery(cQuery);
			newClazz = q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return (T) newClazz;
	}

	@Override
	public List<T> findAllByKeyVal(String key, String value) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> list = new ArrayList<T>();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> cQuery = builder.createQuery(super.klazz);
			Root<T> root = cQuery.from(super.klazz);
			cQuery.select(root).where(builder.equal(root.get(key), value));
			Query<T> q = session.createQuery(cQuery);
			list = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<T> findAll() {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> list = new ArrayList<T>();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery = builder.createQuery(super.klazz);
			Root<T> root = criteriaQuery.from(super.klazz);
			criteriaQuery.select(root);
			Query<T> query = session.createQuery(criteriaQuery);
			list = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean create(T entity) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (entity != null) {
			try {
				session.persist(entity);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean update(T entity) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (entity != null) {
			try {
				session.update(entity);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean merge(T entity) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (entity != null) {
			try {
				session.merge(entity);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
			} finally {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean delete(T entity) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (entity != null) {
			try {
				session.delete(entity);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean deleteById(long entityId) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaDelete<T> cDelete = builder.createCriteriaDelete(super.klazz);
			Root<T> root = cDelete.from(super.klazz);
			cDelete.where(builder.equal(root.get("id"), entityId));
			session.createQuery(cDelete).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean exists(long id) {
		return findOneById(id) != null ? true : false;
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

}