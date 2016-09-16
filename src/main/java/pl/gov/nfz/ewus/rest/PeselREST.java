package pl.gov.nfz.ewus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.gov.nfz.ewus.PeselValidator;
import pl.gov.nfz.ewus.model.Person;

@RestController
public class PeselREST {

	@Autowired
	PeselValidator peselValidator;

	public PeselREST() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/isInsured")
	public ResponseEntity<Person> isInsured() {
		Person person = new Person();
		person.setPesel(76010401692l);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkConnection")
	public String checkConnection() {
		return "OK";
	}

}
