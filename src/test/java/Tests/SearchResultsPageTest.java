package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.SearchResultsPage;
import Utils.ExcelUtility;

public class SearchResultsPageTest extends BaseTest {
	String FilePath = "C:\\parthi\\EclipseWS\\Framework\\src\\test\\java\\Data\\testdata.xlsx";
	public SearchResultsPageTest() {
		super();
	}
	
	@Test(enabled=true)
	public void verifySearchButtonFunctionality() {
		HomePage hpObj = new HomePage(driver);
		hpObj.enterSearchText("Selenium");
		hpObj.clickSearchButton();
		String title = hpObj.getPageTitle();
		System.out.println(title);
		SearchResultsPage srbObj = new SearchResultsPage(driver);
		srbObj.verifyLogoPresent();
		srbObj.clickGoogleLogo();
		hpObj.verifyPageTitle();	
	}
	
	@Test(enabled=false)
	public void getTotalRows() throws IOException {
		ExcelUtility.getTotalRows(FilePath, "Sheet1");
		ExcelUtility.getTotalColumns(FilePath, "Sheet1", 0);
	}
}
