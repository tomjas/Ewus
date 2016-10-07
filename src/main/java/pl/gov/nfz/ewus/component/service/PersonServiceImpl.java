package pl.gov.nfz.ewus.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.gov.nfz.ewus.component.PeselValidator;
import pl.gov.nfz.ewus.component.repository.PersonDao;
import pl.gov.nfz.ewus.exception.AmbiguousPeselException;
import pl.gov.nfz.ewus.exception.IllegalPeselNumberException;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;
import pl.gov.nfz.ewus.model.Person;

/**
 * @author Tomasz Jasiński
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PeselValidator peselValidator;

	@Transactional
	@Override
	public Person registerPerson(final Person person) {
		return personDao.create(person);
	}

	@Transactional
	@Override
	public Person updatePerson(final Person person) {
		verifyPesel(person.getPesel());
		return personDao.update(person);
	}

	@Override
	public Person getByPesel(final String pesel) {
		verifyPesel(pesel);
		List<Person> list = personDao.getByPesel(pesel);
		checkSinglePersonList(list);
		return list.get(0);
	}

	public boolean checkSinglePersonList(final List<Person> list) {
		if (list.isEmpty()) {
			throw new NoSuchPersonException("pesel.no.such.person");
		}

		if (list.size() > 1) {
			throw new AmbiguousPeselException("pesel.ambiguous");
		}

		return true;
	}

	@Override
	public List<Person> getAllRegisteredPeople() {
		return personDao.getAll();
	}

	public boolean verifyPesel(final String pesel) {
		peselValidator.validate(pesel);

		if (!peselValidator.isValid()) {
			throw new IllegalPeselNumberException("pesel.incorrect");
		}

		return true;

	}

	@Override
	public Person getPersonDetails(Long personId) {

		List<Person> list = personDao.getByIdWithDetails(personId);
		if (list.isEmpty()) {
			throw new NoSuchPersonException();
		}

		return list.get(0);
	}

}
