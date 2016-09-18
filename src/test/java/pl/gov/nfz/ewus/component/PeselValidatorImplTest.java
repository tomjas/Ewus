package pl.gov.nfz.ewus.component;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.gov.nfz.ewus.model.Person.Sex;

public class PeselValidatorImplTest {

	private PeselValidatorImpl peselValidator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		peselValidator = new PeselValidatorImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateProperPesel() {
		String pesel = "76010401692";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertTrue(result);
	}

	@Test
	public void testValidateImproperPesel() {
		String pesel = "76040104692";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertFalse(result);
	}
	
	@Test
	public void testValidateImproperPesel1() {
		String pesel = "76-01-04-01-692";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertFalse(result);
	}

	@Test
	public void testValidateImproperPesel2() {
		String pesel = "76 01 04 01 692";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertFalse(result);
	}

	@Test
	public void testValidateImproperPesel3() {
		String pesel = "00000000000";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertFalse(result);
	}

	@Test
	public void testValidateImproperPesel4() {
		String pesel = "76040104695";
		peselValidator.validate(pesel);
		Boolean result = peselValidator.isValid();
		assertFalse(result);
	}

	@Test
	public void testGetBirthYear1976() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.getBirthYear()==1976);
	}

	@Test
	public void testGetBirthMonth01() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.getBirthMonth()==1);
	}

	@Test
	public void testGetBirthMonth04() {
		peselValidator.validate("76040104692");
		assertTrue(peselValidator.getBirthMonth()==4);
	}
	
	@Test
	public void testGetBirthDay04() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.getBirthDay()==4);
	}
	
	@Test
	public void testGetBirthDay01() {
		peselValidator.validate("76040104692");
		assertTrue(peselValidator.getBirthDay()==1);
	}

	@Test
	public void testGetSexMale() {
		String pesel = "76010401692";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.MALE));
	}
	
	@Test
	public void testGetSexMale1() {
		String pesel = "76010401672";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.MALE));
	}
	
	@Test
	public void testGetSexMale2() {
		String pesel = "76010401652";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.MALE));
	}
	
	@Test
	public void testGetSexMale3() {
		String pesel = "76010401632";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.MALE));
	}
	
	@Test
	public void testGetSexMale4() {
		String pesel = "76010401612";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.MALE));
	}
	
	@Test
	public void testGetSexFemale() {
		String pesel = "76010401682";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.FEMALE));
	}
	
	@Test
	public void testGetSexFemale1() {
		String pesel = "76010401662";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.FEMALE));
	}
	
	@Test
	public void testGetSexFemale2() {
		String pesel = "76010401642";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.FEMALE));
	}
	
	@Test
	public void testGetSexFemale3() {
		String pesel = "76010401622";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.FEMALE));
	}
	
	@Test
	public void testGetSexFemale4() {
		String pesel = "76010401602";
		peselValidator.validate(pesel);
		setAccessible("valid");
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.FEMALE));
	}
	
	@Test
	public void testGetSexUndefined() {
		String pesel = "76010401682";
		peselValidator.validate(pesel);
		Sex sex = peselValidator.getSex();
		assertTrue(sex.equals(Sex.UNDEFINED));
	}

	@Test
	public void testCheckSumTrue() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.checkSum());
	}

	@Test
	public void testCheckSumFalse() {
		peselValidator.validate("76040104692");
		assertFalse(peselValidator.checkSum());
	}
	
	@Test
	public void testCheckMonth() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.checkMonth());
	}

	@Test
	public void testCheckDay() {
		peselValidator.validate("76010401692");
		assertTrue(peselValidator.checkDay());
	}

	@Test
	public void testLeapYear2016() {
		assertTrue(peselValidator.leapYear(2016));
	}

	@Test
	public void testLeapYear2000() {
		assertTrue(peselValidator.leapYear(2000));
	}

	@Test
	public void testLeapYear1900() {
		assertFalse(peselValidator.leapYear(1900));
	}

	@Test
	public void testLeapYear2015() {
		assertFalse(peselValidator.leapYear(2015));
	}

	@Test
	public void testLeapYear1976() {
		assertTrue(peselValidator.leapYear(1976));
	}

	@Test
	public void testLeapYear1980() {
		assertTrue(peselValidator.leapYear(1980));
	}

	@Test
	public void testLeapYear1988() {
		assertTrue(peselValidator.leapYear(1988));
	}

	@Test
	public void testLeapYear1802() {
		assertFalse(peselValidator.leapYear(1802));
	}

	@Test
	public void testLeapYear1410() {
		assertFalse(peselValidator.leapYear(1410));
	}

	@Test
	public void testLeapYear2006() {
		assertFalse(peselValidator.leapYear(2006));
	}

	@Test
	public void testLeapYear2008() {
		assertTrue(peselValidator.leapYear(2008));
	}
	
	public void setAccessible(String field){
		Field valid;
		try {
			valid = PeselValidatorImpl.class.getDeclaredField(field);
			valid.setAccessible(true);
			valid.set(peselValidator, true);
		} catch (IllegalAccessException|NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
