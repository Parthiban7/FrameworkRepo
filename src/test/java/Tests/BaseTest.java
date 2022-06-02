package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {	
	public static WebDriver driver;
	public static Properties prop;
	
	/* public static Logger logger; */

	public BaseTest() {
		File src = new File(".\\src\\test\\java\\Config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		/*
		 * logger = Logger.getLogger("ebanking");
		 * PropertyConfigurator.configure("Log4j.properties");
		 */
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		initialization();				
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
