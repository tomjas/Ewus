package pl.gov.nfz.ewus.component.repository;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	@PersistenceContext
	EntityManager em;

	public GenericDaoImpl() {
	}

	@Override
	public long countAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T create(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public T find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
