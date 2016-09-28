package pl.gov.nfz.ewus.component.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.gov.nfz.ewus.component.service.PersonService;
import pl.gov.nfz.ewus.model.InsuranceStatus;

@RestController
public class PeselREST {

	@Autowired
	private PersonService personService;

	public PeselREST() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/isInsured", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InsuranceStatus> isInsured(@RequestBody final String pesel) {
		InsuranceStatus status = personService.getInsuranceStatus(pesel);
		return new ResponseEntity<InsuranceStatus>(status, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkConnection")
	public String checkConnection() {
		return "OK";
	}

}
