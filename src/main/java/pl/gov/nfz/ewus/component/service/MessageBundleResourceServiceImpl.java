/**
 * 
 */
package pl.gov.nfz.ewus.component.service;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * @author Tomasz Jasiński
 *
 */
@Service
public class MessageBundleResourceServiceImpl implements MessageBundleResourceService {

	@Override
	public Properties getProperties(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		return convertResourceBundleToProperties(bundle);
	}

	public Properties convertResourceBundleToProperties(ResourceBundle bundle) {
		Properties properties = new Properties();
		Set<String> keys = bundle.keySet();
		keys.stream().forEach(key -> properties.put(key, bundle.getString(key)));

		return properties;
	}

}
