/**
 * 
 */
package pl.gov.nfz.ewus.component.controller.rest;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.gov.nfz.ewus.component.service.MessageBundleResourceServiceImpl;

/**
 * @author Tomasz Jasiński
 *
 */
@RestController
@RequestMapping(value = "/messageBundle", method = RequestMethod.GET)
public class MessageBundleController {

	@Autowired
	private MessageBundleResourceServiceImpl messageBundleResource;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Properties getMessageBundle(@RequestParam String lang) {
		return messageBundleResource.getProperties(new Locale(lang));
	}

}
