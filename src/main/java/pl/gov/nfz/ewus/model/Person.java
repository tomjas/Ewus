package pl.gov.nfz.ewus.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import pl.gov.nfz.ewus.model.view.HealthCareProvider;
import pl.gov.nfz.ewus.model.view.Operator;

/**
 * @author Tomasz Jasiński
 *
 */
@Table(name = "ewus_person")
@Entity
@NamedQueries({ @NamedQuery(name = Person.GET_BY_PESEL, query = "FROM Person p WHERE p.pesel = :pesel"),
		@NamedQuery(name = Person.GET_BY_ID, query = "FROM Person p WHERE p.id = :id"),
		@NamedQuery(name = Person.GET_BY_INSURANCE_STATUS,
				query = "FROM Person p WHERE p.insuranceStatus = :insuranceStatus"),
		@NamedQuery(name = Person.GET_BY_ID_WITH_DETAILS,
				query = "FROM Person p LEFT JOIN FETCH p.address a WHERE p.id = :id") })
public class Person extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786622396480067538L;
	public static final String GET_BY_PESEL = "getByPesel";
	public static final String GET_BY_ID = "getById";
	public static final String GET_BY_ID_WITH_DETAILS = "getByIdWithDetails";
	public static final String GET_BY_INSURANCE_STATUS = "getByInsuranceStatus";

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public enum Sex {
		MALE, FEMALE, UNDEFINED;
	}

	public enum InsuranceStatus {
		YES, NO, UNDEFINED;
	}

	@JsonView(Operator.class)
	private Long id;

	@JsonView(Operator.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime creationDate;

	@JsonView(Operator.class)
	@Column(name = "pesel", length = 11)
	@Length(min = 11, max = 11)
	private String pesel;

	@JsonView(Operator.class)
	@Column(name = "first_name")
	private String firstName;

	@JsonView(Operator.class)
	@Column(name = "last_name")
	private String lastName;

	@JsonView(Operator.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@JsonView(HealthCareProvider.class)
	@Column(name = "is_insured")
	@Enumerated(EnumType.ORDINAL)
	private InsuranceStatus insuranceStatus;

	@JsonView(Operator.class)
	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;

	@JsonView(Operator.class)
	@Column(name = "date_of_die")
	private LocalDateTime dateOfDie;

	@JsonView(Operator.class)
	@Column(name = "is_living")
	private Boolean living;

	@JsonView(Operator.class)
	@Column(name = "sex")
	@Enumerated(EnumType.ORDINAL)
	private Sex sex;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public InsuranceStatus getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getDateOfDie() {
		return dateOfDie;
	}

	public void setDateOfDie(LocalDateTime dateOfDie) {
		this.dateOfDie = dateOfDie;
	}

	public Boolean isLiving() {
		return living;
	}

	public void setLiving(Boolean living) {
		this.living = living;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

}
