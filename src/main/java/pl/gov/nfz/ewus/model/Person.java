package pl.gov.nfz.ewus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "ewus_person")
@Entity
@NamedQueries({ @NamedQuery(name = Person.GET_BY_PESEL, query = "SELECT p FROM Person p WHERE p.pesel = :pesel"),
		@NamedQuery(name = Person.GET_BY_ID, query = "SELECT p FROM Person p WHERE p.id = :id") })
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786622396480067538L;
	public static final String GET_BY_PESEL = "getByPesel";
	public static final String GET_BY_ID = "getById";

	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "pesel", length = 11)
	@NotBlank
	private Long pesel;

	@Column(name = "first_name")
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	private String lastName;

	@Embedded
	private Address address;

	@Column(name = "role")
	private Role role;

	@Column(name = "is_insured")
	@Enumerated(EnumType.STRING)
	private InsuranceStatus insuranceStatus;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.TIMESTAMP)
	@NotBlank
	private Date dateOfBirth;

	@Column(name = "date_of_die")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfDie;

	@Column(name = "is_living")
	private Boolean living;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPesel() {
		return pesel;
	}

	public void setPesel(Long pesel) {
		this.pesel = pesel;
	}

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

}
