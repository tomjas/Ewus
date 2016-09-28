/**
 * 
 */
package pl.gov.nfz.ewus.model.converter;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Tomasz Jasiński
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalaDateTimeConverterTest {

	@InjectMocks
	private LocalaDateTimeConverter localDateTimeConverter;

	private LocalDateTime localDateTime;
	private Timestamp timeStamp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		localDateTime = LocalDateTime.parse("2016-09-28T20:22:52.324");
		timeStamp = Timestamp.valueOf("2016-09-28 20:22:52.324");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.model.converter.LocalaDateTimeConverter#convertToDatabaseColumn(java.time.LocalDateTime)}.
	 */
	@Test
	public void testConvertToDatabaseColumn() {
		assertTrue(timeStamp.equals(localDateTimeConverter.convertToDatabaseColumn(localDateTime)));
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.model.converter.LocalaDateTimeConverter#convertToEntityAttribute(java.sql.Timestamp)}.
	 */
	@Test
	public void testConvertToEntityAttribute() {
		assertTrue(localDateTime.equals(localDateTimeConverter.convertToEntityAttribute(timeStamp)));
	}

}
