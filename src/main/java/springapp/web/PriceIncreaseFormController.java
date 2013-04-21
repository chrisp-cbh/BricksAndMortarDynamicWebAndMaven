package springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import springapp.service.PriceIncrease;
import springapp.service.ProductManager;

@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseFormController {

	@Autowired
	private ProductManager productManager;

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(20);
		model.addAttribute("priceIncrease", priceIncrease);
		return ("priceincrease");
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
			BindingResult result, SessionStatus status) {

		int increase = priceIncrease.getPercentage();

		productManager.increasePrice(increase);
		status.setComplete();
		
		//TODO track down why this needs .htm on the end (but not in the example
		return "redirect:welcome.htm";
	}
}