package springapp.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.samples.context.WebContextLoader;

import springapp.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = {
		"classpath:/META-INF/spring/root-context.xml",
		"classpath:/META-INF/spring/spring-security-config.xml",
		"classpath:/META-INF/spring/springapp/servlet-context.xml" })
public class ProductControllerTest {

	@Autowired
	ProductService productService;

	@Test
	public void testMyEvents() throws Exception {
		Authentication auth = new UsernamePasswordAuthenticationToken(
				"user1@example.com", "user1");
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(auth);

		// calendarService.findForUser(0);
		SecurityContextHolder.clearContext();
	}

	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testForbiddenEvents() throws Exception {
		// calendarService.findForUser(0);
	}

	// }
	@Test(expected = AccessDeniedException.class)
	public void testWrongUserEvents() throws Exception {
		Authentication auth = new UsernamePasswordAuthenticationToken(
				"user2@example.com", "user2");
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(auth);

		// calendarService.findForUser(0);
		SecurityContextHolder.clearContext();
	}
}
