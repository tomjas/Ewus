package pl.gov.nfz.ewus.component.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pl.gov.nfz.ewus.model.Person;

/**
 * @author Tomasz Jasiński
 *
 */
@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

	@Override
	public List<Person> getByPesel(final String pesel) {
		TypedQuery<Person> query = em.createNamedQuery(Person.GET_BY_PESEL, Person.class);
		query.setParameter("pesel", pesel);
		return query.getResultList();
	}
}
