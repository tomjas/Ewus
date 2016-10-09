/**
 * 
 */
package pl.gov.nfz.ewus.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import pl.gov.nfz.ewus.model.view.Operator;

/**
 * @author Tomasz Jasiński
 *
 */
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonView(Operator.class)
	private Long id;

	@Column(name = "creation_date")
	@JsonView(Operator.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime creationDate = LocalDateTime.now();

	// TODO Add modification date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
