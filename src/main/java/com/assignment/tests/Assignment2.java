package com.assignment.tests;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.gecko.driver",
				"/home/ubuntushree/Documents/all-selenium/geckodriver-v0.24.0-linux64/geckodriver");
// go to TRIPADVISOR

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.tripadvisor.in/");
//
//		// search
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("mainSearch")).sendKeys("club mahindra");
		driver.findElement(By.id("SEARCH_BUTTON_CONTENT")).click();

		// select the first option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();
//		// click on "write a review"

		Set<String> wHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		System.out.println("Current handle is " + currentHandle);
		System.out.println("List of current handles " + wHandles);
		wHandles.remove(currentHandle);
		String clubMahindraHandle = wHandles.iterator().next();
		driver.switchTo().window(clubMahindraHandle);

		Thread.sleep(5000);
		WebElement we = driver.findElement(By.xpath("//a[@class='ui_button primary']"));
		we.click();

		// give review
		wHandles = driver.getWindowHandles();
		System.out.println("List of current handles " + wHandles);
		wHandles.remove(currentHandle);
		wHandles.remove(clubMahindraHandle);
		driver.switchTo().window(wHandles.iterator().next());
		// click on rating

		Thread.sleep(5000);

		driver.get(
				"https://www.tripadvisor.in/UserReviewEdit-g641714-d1156207-Club_Mahindra_Madikeri_Coorg-Madikeri_Kodagu_Coorg_Karnataka.html");
		WebElement starImg = driver.findElement(By.id("bubble_rating"));
		Thread.sleep(5000L);
		Assignment2.selectRating(driver, starImg, 5);
		driver.findElement(By.id("ReviewTitle")).sendKeys("Nice review!!!");
		driver.findElement(By.id("ReviewText")).sendKeys("good job done");

		try {
			WebElement hotelRatings = driver.findElement(By.id("DQ_RATINGS"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", hotelRatings);
			Thread.sleep(3000L);

			Actions act = new Actions(driver);
			act.moveToElement(hotelRatings).perform();

			WebElement servicRatingWe = driver.findElement(By.id("qid12_bubbles"));
			Assignment2.selectRating(driver, servicRatingWe, 5);

			WebElement cleanlinessRatingWe = driver.findElement(By.id("qid14_bubbles"));
			Assignment2.selectRating(driver, cleanlinessRatingWe, 5);

			WebElement sleepRatingWe = driver.findElement(By.id("qid190_bubbles"));
			Assignment2.selectRating(driver, sleepRatingWe, 5);
		} catch (NoSuchElementException e) {
			System.out.println("Hotel rating section not available!!");
		}
	}

	public static void selectRating(WebDriver wd, WebElement we, int rating) {
		// get width of starImg
		int wStar = we.getRect().width;
		System.out.println("Width of star ratings " + wStar);
		int starOffset = wStar / 5;
		int offsetx = ((rating - 1) * starOffset) + (starOffset / 2) - (wStar / 2);
		System.out.println("Offset calculated is " + offsetx);
		Actions act = new Actions(wd);
		act.moveToElement(we).moveByOffset(offsetx, 0).click().pause(2000).perform();
	}

}
