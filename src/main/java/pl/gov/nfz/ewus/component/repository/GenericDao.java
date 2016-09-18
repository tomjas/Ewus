package pl.gov.nfz.ewus.component.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T extends Serializable> {

	long countAll(Map<String, Object> params);
	
	List<T> getAll();

	T create(T t);

	void delete(Serializable id);

	T find(Serializable id);

	T update(T t);

}
