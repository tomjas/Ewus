package pl.gov.nfz.ewus.component.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pl.gov.nfz.ewus.component.service.PersonService;
import pl.gov.nfz.ewus.model.Person;
import pl.gov.nfz.ewus.model.view.Operator;

@RestController
@RequestMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

	@Autowired
	PersonService personService;

	@JsonView(Operator.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getRegisteredPeople() {
		List<Person> registeredPeople = personService.getAllRegisteredPeople();
		return new ResponseEntity<List<Person>>(registeredPeople, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> registerPerson(@RequestBody final Person person) {
		Person registeredPerson = personService.registerPerson(person);
		return new ResponseEntity<Person>(registeredPerson, HttpStatus.OK);
	}

	@RequestMapping(value = "/{personId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> updatePerson(@RequestBody final Person person, @PathVariable Long personId) {
		Person updatedPerson = personService.updatePerson(person);
		return new ResponseEntity<Person>(updatedPerson, HttpStatus.OK);
	}

	@JsonView(Operator.class)
	@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonDetails(@PathVariable Long personId) {
		Person person = personService.getPersonDetails(personId);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

}
