package pl.gov.nfz.ewus.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Tomasz Jasiński
 *
 */
@Table(name = "ewus_person")
@Entity
@NamedQueries({ @NamedQuery(name = Person.GET_BY_PESEL, query = "SELECT p FROM Person p WHERE p.pesel = :pesel"),
		@NamedQuery(name = Person.GET_BY_ID, query = "SELECT p FROM Person p WHERE p.id = :id"),
		@NamedQuery(name = Person.GET_BY_INSURANCE_STATUS,
				query = "FROM Person p WHERE p.insuranceStatus = :insuranceStatus") })
public class Person extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786622396480067538L;
	public static final String GET_BY_PESEL = "getByPesel";
	public static final String GET_BY_ID = "getById";
	public static final String GET_BY_INSURANCE_STATUS = "getByInsuranceStatus";

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public enum Sex {
		MALE, FEMALE, UNDEFINED;
	}

	@Column(name = "pesel", length = 11)
	@NotBlank
	@Length(min = 11, max = 11)
	private String pesel;

	@Column(name = "first_name")
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "role")
	private Role role;

	@Column(name = "is_insured")
	@Enumerated(EnumType.STRING)
	private InsuranceStatus insuranceStatus;

	@Column(name = "date_of_birth")
	@NotBlank
	private LocalDateTime dateOfBirth;

	@Column(name = "date_of_die")
	private LocalDateTime dateOfDie;

	@Column(name = "is_living")
	private boolean living;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

}
