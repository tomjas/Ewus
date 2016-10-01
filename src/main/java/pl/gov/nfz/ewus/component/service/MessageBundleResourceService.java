/**
 * 
 */
package pl.gov.nfz.ewus.component.service;

import java.util.Locale;
import java.util.Properties;

/**
 * @author Tomasz Jasiński
 *
 */
public interface MessageBundleResourceService {

	Properties getProperties(Locale locale);

}
