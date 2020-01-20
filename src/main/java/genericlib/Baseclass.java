package genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Baseclass {

	public static WebDriver driver;

	@BeforeClass
	public void configBC() throws Throwable {

		System.out.println("LAUNCH THE BROWSER");
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void configAM() throws Throwable {
		System.out.println("LOGOUT");
	}

	@AfterClass
	public void configAC() {
		System.out.println("CLOSE BROWSER");
		driver.quit();
	}

}