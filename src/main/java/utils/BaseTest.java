package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.BasePage;

public class BaseTest {
	
	public static WebDriver driver;
	public BasePage app;
	
	@Parameters({"appURL"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String url) {
		//System.setProperty("webdriber.chrome.driver", "path//chromedriver.exe")	
		driver =  new ChromeDriver();
		driver.manage().window().maximize();//face maximize la browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		app = new BasePage();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);// bad practice
		driver.close();	//inchide doar tabul curent
	//	driver.quit();// inchide browserul indifiernt cate tab-uri are deschise 
		
	}
	

}
