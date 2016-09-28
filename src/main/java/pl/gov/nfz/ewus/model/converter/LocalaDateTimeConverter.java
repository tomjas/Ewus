/**
 * 
 */
package pl.gov.nfz.ewus.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Tomasz Jasiński
 *
 */
@Converter(autoApply = true)
public class LocalaDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		Timestamp result = null;
		if (localDateTime != null) {
			result = Timestamp.valueOf(localDateTime);
		}
		return result;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		LocalDateTime localDateTime = null;
		if (timestamp != null) {
			localDateTime = timestamp.toLocalDateTime();
		}
		return localDateTime;
	}

}
