package pl.gov.nfz.ewus.component.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pl.gov.nfz.ewus.component.service.PersonService;
import pl.gov.nfz.ewus.model.Person;
import pl.gov.nfz.ewus.model.view.HealthCareProvider;

/**
 * @author Tomasz Jasiński
 *
 */
@RestController
@RequestMapping(value = "/pesel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class PeselController {

	@Autowired
	private PersonService personService;

	public PeselController() {
		// TODO Auto-generated constructor stub
	}

	@JsonView(HealthCareProvider.class)
	@RequestMapping
	public ResponseEntity<Person> isInsured(@RequestBody Person person) {
		Person dbPerson = personService.getByPesel(person.getPesel());
		return new ResponseEntity<Person>(dbPerson, HttpStatus.OK);
	}

}
