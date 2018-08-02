package frameworkImplement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base {

	public boolean inHomePage() {

		boolean found = false;

		if (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-ex1-collapse")) != null)

		{
			found = true;
			System.out.println("found a homepage navbar");
		}
		return found;

	}
	
}
