package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.SearchResultsPage;
import Utils.ExcelUtility;

public class DataProviderTest extends BaseTest{
	public DataProviderTest() {
		super();
	}	
	String FilePath = "C:\\parthi\\EclipseWS\\Framework\\src\\test\\java\\Data\\testdata.xlsx";
	
	@Test(dataProvider = "data")
	public void TestData(String searchData) {
		HomePage hpObj = new HomePage(driver);
		SearchResultsPage srpObj = new SearchResultsPage(driver);
		hpObj.enterSearchText(searchData);
		hpObj.clickSearchButton();
		srpObj.getResultPageTitle();	
		srpObj.clickGoogleLogo();
	}	
	
	@DataProvider(name="data")
	public String[][] getData() throws IOException{
		String path = "C:\\parthi\\EclipseWS\\Framework\\src\\test\\java\\Data\\testdata.xlsx";
		int rownum = ExcelUtility.getTotalRows(path, "Sheet1");
		int colnum = ExcelUtility.getTotalColumns(path, "Sheet1", 1);
		String data[][] = new String[rownum-1][colnum];
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colnum;j++) {
				data[i-1][j]=ExcelUtility.getCellData(path, "Sheet1", i, j);
				System.out.println(data[i-1][j]);
			}
		}		
		return data;
	}
}
