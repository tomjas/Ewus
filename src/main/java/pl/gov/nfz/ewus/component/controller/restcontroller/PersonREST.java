package pl.gov.nfz.ewus.component.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.gov.nfz.ewus.component.service.PersonService;
import pl.gov.nfz.ewus.model.Person;

@RestController
public class PersonREST {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getRegisteredPeople() {
		List<Person> registeredPeople = personService.getAllRegisteredPeople();
		return new ResponseEntity<List<Person>>(registeredPeople, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> registerPerson(@RequestBody final Person person) {
		Person registeredPerson = personService.registerPerson(person);
		return new ResponseEntity<Person>(registeredPerson, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> updatePerson(@RequestBody final Person person) {
		Person updatedPerson = personService.updatePerson(person);
		return new ResponseEntity<Person>(updatedPerson, HttpStatus.OK);
	}

}
