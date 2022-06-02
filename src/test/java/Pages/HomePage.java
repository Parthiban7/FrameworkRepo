package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="q")
	WebElement searchBox;

	@FindBy(name="btnK")
	WebElement SearchButton;
	
	public String getPageTitle() {
		String title = ldriver.getTitle();
		return title;
	}
	
	public void verifyPageTitle() {
		String title = ldriver.getTitle();
		Assert.assertEquals(title, "Google");
	}
	
	public void enterSearchText(String data) {
	searchBox.sendKeys(data);	
	}
	
	public void clickSearchButton() {
		SearchButton.click();
	}

}
