package springapp.web;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

public class WelcomeControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{
        WelcomeController controller = new WelcomeController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals( "welcome", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
    }
}