package pl.gov.nfz.ewus.component.service;

import java.util.List;

import pl.gov.nfz.ewus.model.InsuranceStatus;
import pl.gov.nfz.ewus.model.Person;

public interface PersonService {
	Person register(Person person);

	Person update(Person person);

	List<Person> getAllRegisteredPeople();

	InsuranceStatus getInsuranceStatus(String pesel);

}
