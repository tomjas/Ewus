package pl.gov.nfz.ewus.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.gov.nfz.ewus.component.PeselValidator;
import pl.gov.nfz.ewus.component.repository.PersonDao;
import pl.gov.nfz.ewus.exception.AmbiguousPeselException;
import pl.gov.nfz.ewus.exception.IllegalPeselNumberException;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;
import pl.gov.nfz.ewus.model.InsuranceStatus;
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

	@Override
	public Person registerPerson(final Person person) {
		return personDao.create(person);
	}

	@Override
	public Person updatePerson(final Person person) {
		verifyPesel(person.getPesel());
		return personDao.update(person);
	}

	@Override
	public InsuranceStatus getInsuranceStatus(final String pesel) {
		verifyPesel(pesel);
		List<Person> list = personDao.getByPesel(pesel);
		checkSinglePersonList(list);
		return list.get(0).getInsuranceStatus();
	}

	public boolean checkSinglePersonList(final List<Person> list) {
		if (list.isEmpty()) {
			throw new NoSuchPersonException();
		}

		if (list.size() > 1) {
			throw new AmbiguousPeselException();
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
			throw new IllegalPeselNumberException();
		}

		return true;

	}

}
