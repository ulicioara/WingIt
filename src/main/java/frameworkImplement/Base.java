package frameworkImplement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constants.*;

public class Base {
	public static WebDriver driver;
	public static WebDriverWait wait;
	LocatorType loctype = new LocatorType();

	public void initSetBase() {
		// we instantiate and declare the driver here and base test extends it
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// 15 seconds
		wait = new WebDriverWait(driver, 15);

		System.out.println("starting driver");

		driver.manage().window().maximize();

	}

	public WebElement findElementOwn(String locatorType, String locator, boolean mandatory) {

		// the function requires locatorType(id, css etc) , locator(the actual .ddss or
		// #akdh) and the mandatory boolean variable that decides if we can go on with
		// the test or not

		WebElement webElement = null;
		By loctype = null;

		// based on what selector is wanted, create a variable to later use in
		// driver.findElement

		LocatorType locType = new LocatorType();

		if (locatorType.equals(locType.cssSelector())) {

			loctype = By.cssSelector(locator);

		} else if (locatorType.equals(locType.id())) {

			loctype = By.id(locator);

		} else if (locatorType.equals(locType.theClass())) {
			loctype = By.className(locator);

		} else if (locatorType.equals(locType.xPath())) {
			loctype = By.xpath(locator);
		}

		else {
			System.out.println("invalid locator type");
			return null;
		}

		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loctype));
			webElement = driver.findElement(loctype);
		} catch (Exception e) {
			webElement = null;
		}

		if (mandatory == true && webElement == null) {

			System.out.println("element is mandatory but has not been found");
			System.exit(1);
			return null;

		} else

			return webElement;

	}

	public void clickObject(String locatorType, String locator, boolean mandatory) {

		WebElement w = findElementOwn(locatorType, locator, mandatory);
		boolean visible = false;
		Actions builder = new Actions(driver);
		// iterator care sa opreasca actiunea daca se tot incearca si nu reuseste sa
		// gaseasca visibil elementul pe pagina, sa nu intre in bucla infinita
		int i = 10;

		// element could be not found so we don't want to crash if we take properties
		// from a null
		if (w == null)
			return;

		while (visible == false && i != 0) {

			System.out.println("element may not visible");

			// go to it
			builder.moveToElement(w).build().perform();

			// check if now is visible
			if (ExpectedConditions.visibilityOf(w) != null) {
				visible = true;
				System.out.println("element is now visible");
			}

			i--;

		}

		w.click();
		System.out.println("element clicked");

	}

	public void setObject(String fieldType, String valueToSet, String locatorType, String locator, boolean mandatory) {

		if (valueToSet.equals(null)) {
			System.out.println("Please input a valid value to set");
			return;
		}

		WebElement w = findElementOwn(locatorType, locator, mandatory);

		// ! deal with different types of fields

		if (fieldType.equals("textBox") || fieldType.equals("dropdown")) {
			w.click();
			w.clear();
			w.sendKeys(valueToSet);
		}

		else if (fieldType.equals("button")) {

			if (w.getText().equals(valueToSet))
				w.click();
		}

	}

	public String getObjectValue(String valueToGet, String attributeToGet, String cssToGet, String locatorType,
			String locator, boolean mandatory) {

		// value will receive the wanted property
		String value = null;
		WebElement w = findElementOwn(locatorType, locator, mandatory);

		if (w == null)
			return null;

		switch (valueToGet) {
		case "Attribute":
			value = w.getAttribute(attributeToGet);
			break;
		case "Class":
			value = w.getClass().toString();
			break;
		case "CssValue":
			value = w.getCssValue(cssToGet);
			break;
		case "Location":
			value = w.getLocation().toString();
			break;
		case "Rect":
			value = w.getRect().toString();
			break;
		case "Size":
			value = w.getSize().toString();
			break;
		case "TageName":
			value = w.getTagName();
			break;
		case "Text":
			value = w.getText();
			break;

		default:
			System.out.println("enter a valid type of value to get");
			break;

		}

		// to check the value
		System.out.println("Value requested is " + value);
		return value;
	}

}
