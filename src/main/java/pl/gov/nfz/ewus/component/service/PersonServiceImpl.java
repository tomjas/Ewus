package pl.gov.nfz.ewus.component.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.gov.nfz.ewus.component.PeselValidator;
import pl.gov.nfz.ewus.component.repository.PersonDao;
import pl.gov.nfz.ewus.exception.IllegalPeselNumberException;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;
import pl.gov.nfz.ewus.model.InsuranceStatus;
import pl.gov.nfz.ewus.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Autowired
	private PeselValidator peselValidator;

	// TODO Dodać entitymanagera
	// @PersistenceContext
	EntityManager em;

	@Override
	public Person register(final Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(final Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsuranceStatus getInsuranceStatus(final String pesel) {
		verifyPesel(pesel);
		TypedQuery<Person> query = em.createNamedQuery(Person.GET_BY_PESEL, Person.class);
		query.setParameter("pesel", Long.parseLong(pesel));
		List<Person> list = query.getResultList();
		if (list.isEmpty()) {
			throw new NoSuchPersonException();
		}

		return list.get(0).getInsuranceStatus();
	}

	@Override
	public List<Person> getAllRegisteredPeople() {
		return personDao.getAll();
	}

	public void verifyPesel(final String pesel) {
		peselValidator.validate(pesel);
		if (!peselValidator.isValid()) {
			throw new IllegalPeselNumberException("Invalid pesel number!");
		}

	}

}
