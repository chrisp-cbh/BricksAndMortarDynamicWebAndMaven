package springapp.web;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;

import springapp.service.PriceIncrease;
import springapp.service.ProductManager;

@RunWith(MockitoJUnitRunner.class)
public class PriceIncreaseFormControllerTest {

	@Mock
	private ModelMap mockModelMap;
	private PriceIncreaseFormController priceIncreaseFormController;
	@Mock
	private ProductManager mockProductManager;
	@Mock
	private BindingResult mockBindingResult;
	@Mock
	private SessionStatus mockStatus;
	@Mock
	private PriceIncrease mockPriceIncrease;

	@Before
	public void setUp() {
		priceIncreaseFormController = new PriceIncreaseFormController();
		Whitebox.setInternalState(priceIncreaseFormController,
				"productManager", mockProductManager);
	}

	@Test
	public void formCreatesReturnPriceIncreaseMapping() {
		assertThat(priceIncreaseFormController.initForm(mockModelMap),
				equalTo("priceincrease"));
	}

	@Test
	public void initFormCreatesNewPriceIncreaseWithTwentyPercentAndAddsToModel()
			throws Exception {

		// TODO: Try the alternative of using a custom ArgumentMatcher
		ArgumentCaptor<PriceIncrease> argument = ArgumentCaptor
				.forClass(PriceIncrease.class);

		ArgumentCaptor<String> keyArgument = ArgumentCaptor
				.forClass(String.class);

		priceIncreaseFormController.initForm(mockModelMap);

		verify(mockModelMap).addAttribute(keyArgument.capture(),
				argument.capture());
		assertEquals(20, argument.getValue().getPercentage());
		assertEquals("priceIncrease", keyArgument.getValue());
	}

	@Test
	public void processSubmitCallsIncreasePriceWithPassedInPriceIncrease()
			throws Exception {

		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(200);

		priceIncreaseFormController.processSubmit(priceIncrease,
				mockBindingResult, mockStatus);

		verify(mockProductManager).increasePrice(200);
	}

	@Test
	public void processSubmitSetsStatusComplete() {
		priceIncreaseFormController.processSubmit(mockPriceIncrease,
				mockBindingResult, mockStatus);
		verify(mockStatus).setComplete();
	}

	@Test
	public void processSubmitReturnWelcomeRedirect() {
		assertThat(priceIncreaseFormController.processSubmit(mockPriceIncrease,
				mockBindingResult, mockStatus), equalTo("redirect:welcome.htm"));
	}
}
