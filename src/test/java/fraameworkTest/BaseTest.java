package fraameworkTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import frameworkImplement.Base;

public class BaseTest extends Base {

	@BeforeClass
	public void initSetTestBase() {

		initSetBase();
	}

	@AfterClass
	public void tearDownp() {
		// always check if driver is closed. bewaare
		driver.close();
		if (driver != null)
			driver.quit();
		System.out.println("driver closed");

	}

}
