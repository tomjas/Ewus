package pl.gov.nfz.ewus.component;

import pl.gov.nfz.ewus.model.Person.Sex;

public interface PeselValidator {
	
	void validate(String pesel);

	boolean isValid();

	int getBirthYear();

	int getBirthMonth();

	int getBirthDay();

	Sex getSex();

}