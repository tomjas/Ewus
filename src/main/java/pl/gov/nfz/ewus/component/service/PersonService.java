package pl.gov.nfz.ewus.service;

import pl.gov.nfz.ewus.model.InsuranceStatus;
import pl.gov.nfz.ewus.model.Person;

public interface PersonService {
	Person register(Person person);
	InsuranceStatus changeStatus(Person person);
	InsuranceStatus getInsuranceStatus(Person person);
}
