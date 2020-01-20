package testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import genericlib.Baseclass;
import objrepo.tripadvisor.DetailPage;
import objrepo.tripadvisor.HomePage;

public class Assignment2 extends Baseclass {

	@Test()
	public void reviewTripAdvisor() throws Exception {

		HomePage hp = PageFactory.initElements(driver, HomePage.class);

		// open trip advisor home page
		hp.openPage(driver);

		// search for club mahindra
		hp.search("club mahindra");

		// open detail page by selecting first option
		driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();

		// switch windows
		Set<String> wHandles = driver.getWindowHandles();
		String hpHandle = driver.getWindowHandle();
		System.out.println("Current handle is " + hpHandle);
		System.out.println("List of current handles " + wHandles);
		wHandles.remove(hpHandle);
		String clubMahindraHandle = wHandles.iterator().next();
		driver.switchTo().window(clubMahindraHandle);

		DetailPage dp = PageFactory.initElements(driver, DetailPage.class);
		dp.review();

	}
}
