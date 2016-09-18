package pl.gov.nfz.ewus.component.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	// @PersistenceContext
	EntityManager em;

	public GenericDaoImpl() {
	}

	@Override
	public long countAll(final Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<T> getAll(){
		return null;
	}

	@Override
	public T create(final T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(final Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public T find(final Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(final T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
