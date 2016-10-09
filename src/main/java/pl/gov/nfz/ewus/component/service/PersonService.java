package pl.gov.nfz.ewus.component.service;

import java.util.List;

import pl.gov.nfz.ewus.model.Person;

public interface PersonService {
	Person registerPerson(Person person);

	Person updatePerson(Person person);

	List<Person> getAllRegisteredPeople();

	Person getByPesel(String pesel);

	Person getPersonDetails(Long id);

	Person getById(Long personId);

}
