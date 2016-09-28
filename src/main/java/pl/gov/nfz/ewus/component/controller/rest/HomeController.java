/**
 * 
 */
package pl.gov.nfz.ewus.component.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tomasz Jasiński
 *
 */
@RestController
@RequestScope
public class HomeController {

	/**
	 * 
	 */
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

}
