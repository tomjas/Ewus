/**
 * 
 */
package pl.gov.nfz.ewus.component.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import pl.gov.nfz.ewus.component.PeselValidator;
import pl.gov.nfz.ewus.component.repository.PersonDao;
import pl.gov.nfz.ewus.exception.AmbiguousPeselException;
import pl.gov.nfz.ewus.exception.IllegalPeselNumberException;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;
import pl.gov.nfz.ewus.model.InsuranceStatus;
import pl.gov.nfz.ewus.model.Person;
import pl.gov.nfz.ewus.model.PersonBuilder;

/**
 * @author Tomasz Jasiński
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

	@InjectMocks
	PersonServiceImpl personService = new PersonServiceImpl();

	@Spy
	@InjectMocks
	PersonServiceImpl spy;

	Person homer;

	@Mock
	private PersonDao personDao;

	@Mock
	private List<Person> list;

	@Mock
	private PeselValidator peselValidator;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		homer = PersonBuilder.create().withName("Homer").withLastName("Simpson")
				.withInsuranceStatus(InsuranceStatus.YES).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#registerPerson(pl.gov.nfz.ewus.model.Person)}.
	 */
	@Test
	public void testRegisterPerson() {
		when(personDao.create(homer)).thenReturn(homer);
		Person result = personService.registerPerson(homer);
		assertTrue(homer.equals(result));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#updatePerson(pl.gov.nfz.ewus.model.Person)}.
	 */
	@Test
	public void testUpdatePerson() {
		doReturn(true).when(spy).verifyPesel("");
		doReturn(homer).when(spy).updatePerson(homer);
		assertTrue(homer.equals(spy.updatePerson(homer)));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#getInsuranceStatus(java.lang.String)}.
	 */
	@Test
	public void testGetInsuranceStatus() {
		doReturn(true).when(spy).verifyPesel("");
		doReturn(list).when(personDao).getByPesel("");
		doReturn(true).when(spy).checkSinglePersonList(list);
		doReturn(homer).when(list).get(0);
		assertTrue(InsuranceStatus.YES.equals(spy.getInsuranceStatus("")));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#checkSinglePersonList(java.util.List)}.
	 */
	@Test(expected = NoSuchPersonException.class)
	public void testCheckSinglePersonListEmptyList() {
		doReturn(true).when(list).isEmpty();
		personService.checkSinglePersonList(list);
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#checkSinglePersonList(java.util.List)}.
	 */
	@Test(expected = AmbiguousPeselException.class)
	public void testCheckSinglePersonListTwoElementList() {
		doReturn(2).when(list).size();
		personService.checkSinglePersonList(list);
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#checkSinglePersonList(java.util.List)}.
	 */
	@Test
	public void testCheckSinglePersonListSingleElementList() {
		doReturn(1).when(list).size();
		assertTrue(Boolean.TRUE.equals(personService.checkSinglePersonList(list)));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#getAllRegisteredPeople()}.
	 */
	@Test
	public void testGetAllRegisteredPeople() {
		when(personDao.getAll()).thenReturn(list);
		assertTrue(list.equals(personService.getAllRegisteredPeople()));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#verifyPesel(java.lang.String)}.
	 */
	@Test(expected = IllegalPeselNumberException.class)
	public void testVerifyPeselInCorrect() {
		doNothing().when(peselValidator).validate("");
		when(peselValidator.isValid()).thenReturn(false);
		assertTrue(Boolean.TRUE.equals(personService.verifyPesel("")));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.service.PersonServiceImpl#verifyPesel(java.lang.String)}.
	 */
	@Test
	public void testVerifyPeselCorrect() {
		doNothing().when(peselValidator).validate("");
		when(peselValidator.isValid()).thenReturn(true);
		assertTrue(Boolean.TRUE.equals(personService.verifyPesel("")));
	}
}
