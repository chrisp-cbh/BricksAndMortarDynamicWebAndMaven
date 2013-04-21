package springapp.fitnesse.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoldenPathAddSaleDriver {

	// driving chrome
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\workspace\\BricksAndMortar\\lib\\chromedriver.exe");
	}

	public GoldenPathAddSaleDriver() {

		// driver = new RemoteWebDriver(new URL("http://localhost:9515"),
		// DesiredCapabilities.chrome());
		driver = new ChromeDriver();
	}

	// Headless web testing (virtual browser)
	// private WebDriver driver = new HtmlUnitDriver();

	// private WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

	// driving firefox
	// private WebDriver driver = new
	// org.openqa.selenium.firefox.FirefoxDriver();
	private WebElement newSaleLink;
	private WebDriver driver;

	public boolean navigateToWelcomePage() {
		driver.get("http://localhost:8080/bricksandmortar");

		return (driver.getTitle()
				.equals("A warm welcome from Bricks and Mortar"));
	}

	public boolean linkTo(String linkText) {
		List<WebElement> elements = driver.findElements(By.linkText(linkText));
		if (elements.isEmpty()) {
			return false;
		} else {
			newSaleLink = elements.get(0);
			return true;
		}
	}

	public void navigateToCreateSalePage() {
		newSaleLink.click();
	}

	public String newSalePageTitle() {
		return driver.getTitle();
	}

	public boolean enterSaleDetailsWithSalesAssistantAndTillIdAndTimeStamp(
			String salesAssistant, String tillId, String timeStamp) {
		driver.findElement(By.id("salesAssistant")).sendKeys(salesAssistant);
		driver.findElement(By.id("tillId")).sendKeys(tillId);
		driver.findElement(By.id("timeStamp")).sendKeys(timeStamp);
		return true;
	}

	public boolean saveSale() {
		driver.findElement(By.id("submit")).click();
		// could we test here?
		return true;
	}

	public boolean seeSaleInOpenSales() {
		return false;
	}

	public void cleanUp() {
		driver.close();
	}
}
