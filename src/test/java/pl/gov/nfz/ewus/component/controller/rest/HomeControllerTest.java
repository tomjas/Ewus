/**
 * 
 */
package pl.gov.nfz.ewus.component.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.gov.nfz.ewus.config.AppConfiguration;
import pl.gov.nfz.ewus.config.AppInitializer;

/**
 * @author Tomasz Jasiński
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
		classes = { AppInitializer.class, AppConfiguration.class, ServletConfig.class })
@WebAppConfiguration
public class HomeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link pl.gov.nfz.ewus.component.controller.rest.HomeController#getHomePage()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGerHomePage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
	}

}
