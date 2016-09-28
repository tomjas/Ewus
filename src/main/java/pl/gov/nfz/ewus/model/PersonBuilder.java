package pl.gov.nfz.ewus.model;

import java.time.LocalDateTime;

/**
 * @author Tomasz Jasiński
 *
 */
public class PersonBuilder {

	PersonBuilder personBuilder;
	Person person = new Person();

	public static PersonBuilder create() {
		return new PersonBuilder();
	}

	public PersonBuilder withName(final String name) {
		person.setFirstName(name);
		return this;
	}

	public PersonBuilder withLastName(final String lastName) {
		person.setLastName(lastName);
		return this;
	}

	public PersonBuilder withPesel(final String pesel) {
		person.setPesel(pesel);
		return this;
	}

	public PersonBuilder withRole(final Role role) {
		person.setRole(role);
		return this;
	}

	public PersonBuilder withInsuranceStatus(final InsuranceStatus status) {
		person.setInsuranceStatus(status);
		return this;
	}

	public PersonBuilder withDateOfBirth(final LocalDateTime date) {
		person.setDateOfBirth(date);
		return this;
	}

	public PersonBuilder withDateOfDie(final LocalDateTime date) {
		person.setDateOfDie(date);
		return this;
	}

	public PersonBuilder withLiving(final boolean living) {
		person.setLiving(living);
		return this;
	}

	public PersonBuilder withAddress(final Address address) {
		person.setAddress(address);
		return this;
	}

	public Person build() {
		return person;
	}

}
