package fraameworkTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Constants.LocatorType;
import Constants.Text;

public class HomePageTest extends BaseTest {

	String baseURL = "http://demoqa.com/";
	LocatorType loctype=new LocatorType();
	
	@BeforeClass
	public void initSet() {

		driver.navigate().to(baseURL);
		System.out.println("i'm in demoqa");

	}

	@AfterMethod
	public void afterMethod() {
		driver.navigate().to(baseURL);
		System.out.println("I'm in demoqa");

	}

	@Test
	public void textCheck() {

		WebElement we;
		String currentText;
		
		Constants.Text messages = new Constants.Text();
		messages.readMessages(); 
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".navbar-ex1-collapse")));
		System.out.println("found a homepage navbar");
		
		clickObject( loctype.cssSelector(),  ".dropdown-toggle",true);
		System.out.println("clicked the demo button");
		
		clickObject( loctype.cssSelector(),  "#menu-item-153",true);
		System.out.println("clicked the tab button");
		
		clickObject( loctype.cssSelector(),  "#ui-id-3",true);
		System.out.println("clicked the tab3 button");
		
		
		we= findElementOwn( loctype.cssSelector(),  "#tabs-3 p",  true);
		System.out.println("found the element with text 1");
		currentText=we.getText();
		assertEquals(currentText, Text.TAB3TEXT1,"not the first expected text");
	
		we= findElementOwn( loctype.cssSelector(),  "#tabs-3 p+*",  true);
		System.out.println("found the element with text 1");
		currentText=we.getText();
		assertEquals(currentText, Text.TAB3TEXT2,"not the first expected text");

		
	}
}
