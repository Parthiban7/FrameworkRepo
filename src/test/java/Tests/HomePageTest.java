package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends BaseTest {	
	public HomePageTest() {
		super();
	}

	@Test
	public void verifyPageTitle() {
		HomePage hpObj = new HomePage(driver);
		String title = hpObj.getPageTitle();
		Assert.assertEquals(title, "Google");
	}
}
