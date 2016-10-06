package pl.gov.nfz.ewus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Tomasz Jasiński
 *
 */
@Table(name = "ewus_address")
@Entity
public class Address extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3507187855954930912L;

	@NotBlank
	@Column(name = "city")
	private String city;

	@NotBlank
	@Pattern(regexp = "\\d{2}-\\d{3}")
	@Column(name = "code")
	private String code;

	@Column(name = "street")
	private String street;

	@NotBlank
	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "apartment_number")
	private String apartmentNumber;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

}
