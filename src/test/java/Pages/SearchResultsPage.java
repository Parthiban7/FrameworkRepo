package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage {
	
	public WebDriver ldriver;
	
	public SearchResultsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="logo")
	WebElement GoogleLogo;
	
	public void  verifyLogoPresent() {
		boolean result =  GoogleLogo.isDisplayed();
		Assert.assertTrue(result);
	}
	
	public void clickGoogleLogo() {
		GoogleLogo.click();
	}
	
	public void getResultPageTitle() {
		String title = ldriver.getTitle();
		System.out.println(title);
	}
}
