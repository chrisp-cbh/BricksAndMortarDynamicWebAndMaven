package springapp.webdriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverTryingOut {

	@Test
	public void seeIfTheApplicationIsUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\BricksAndMortar\\lib\\chromedriver.exe");
		//FirefoxProfile profile = new FirefoxProfile(new File("C:\\workspace\\FitnesseProfile"));                  
//		WebDriver driver = new FirefoxDriver(profile);
//		WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/bricksandmortar");

		assertThat(driver.getTitle(),
				equalTo("A warm welcome from Bricks and Mortar"));
	}

}
