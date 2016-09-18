package pl.gov.nfz.ewus.component.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pl.gov.nfz.ewus.component.repository.PersonDao;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;
import pl.gov.nfz.ewus.model.InsuranceStatus;
import pl.gov.nfz.ewus.model.Person;

public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@PersistenceContext
	EntityManager em;

	@Override
	public Person register(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsuranceStatus changeStatus(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsuranceStatus getInsuranceStatus(String pesel) {
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

}
