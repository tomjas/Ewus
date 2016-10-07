package pl.gov.nfz.ewus.component.repository;

import java.util.List;

import pl.gov.nfz.ewus.model.Person;

/**
 * @author Tomasz Jasiński
 *
 */
public interface PersonDao extends GenericDao<Person> {

	List<Person> getByPesel(String pesel);

	List<Person> getByIdWithDetails(Long id);

}
