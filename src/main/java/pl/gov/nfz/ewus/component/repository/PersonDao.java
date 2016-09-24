package pl.gov.nfz.ewus.component.repository;

import java.util.List;

import pl.gov.nfz.ewus.model.Person;

public interface PersonDao extends GenericDao<Person> {

	List<Person> getByPesel(String pesel);

}
