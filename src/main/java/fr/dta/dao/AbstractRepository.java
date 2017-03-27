package fr.dta.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.model.AbstractEntity;


@Transactional
public abstract class AbstractRepository<T extends AbstractEntity> {
	

	Class<T> entityClass;

	@PersistenceContext
	EntityManager em;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected Session getSession() {
		return em.unwrap(Session.class);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = getSession().createQuery("from "+entityClass.getSimpleName());
		return query.list();
	}

	public T getById(Integer id) {
		return em.find(entityClass, id);
	}

	public T add(T entity) {
		em.persist(em.merge(entity));
		return entity;
	}

	public void delete(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}

	
}