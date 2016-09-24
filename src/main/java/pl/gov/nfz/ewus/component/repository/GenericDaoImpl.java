package pl.gov.nfz.ewus.component.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> entityClass;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public long countAll(final Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> getAll() {
		StringBuilder sb = new StringBuilder("FROM ");
		sb.append(entityClass.getSimpleName()).append(" t");
		TypedQuery<T> query = em.createQuery(sb.toString(), entityClass);
		return query.getResultList();
	}

	@Override
	public T create(final T t) {
		em.persist(t);
		return t;
	}

	@Override
	public void delete(final T t) {
		em.remove(t);
	}

	@Override
	public T find(final Serializable id) {
		return em.find(entityClass, id);
	}

	@Override
	public T update(final T t) {
		return em.merge(t);
	}

}
