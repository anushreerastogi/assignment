package com.assignment.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"/home/ubuntushree/Documents/all-selenium/geckodriver-v0.24.0-linux64/geckodriver");
// go to amazon
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://www.amazon.in");

		// search for iPhone XR (64gb) -Yellow

//		WebElement wb = driver.findElement(By.id("twotabsearchtextbox"));
//		wb.sendKeys("iphone xr 64gb - yellow");
//		wb.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		// select the phone

//		driver.findElement(By.xpath("//span[text()='Apple iPhone XR (64GB) - Yellow']")).click();
//		Set<String> wHandles = driver.getWindowHandles();
//		String currentHandle = driver.getWindowHandle();
//		System.out.println("Current handle is " + currentHandle);
//		System.out.println("List of current handles " + wHandles);
//		wHandles.remove(currentHandle);
//		String amzHandle = wHandles.iterator().next();
//		driver.switchTo().window(amzHandle);

		// select price
//		Thread.sleep(3000L);
//		WebElement dealPriceBlock = driver.findElement(By.id("priceblock_dealprice"));
//		String price = dealPriceBlock.getText();
//		System.out.println(price);

//		driver.quit();
		// go to flipcart
//		Thread.sleep(2000);
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.flipkart.com/");
//
		driver1.findElement(By.xpath("//button[text()='✕']")).click();
//
//		// search for iPhone XR (64GB) - Yellow
		WebElement searchBox = driver1.findElement(By.name("q"));
		searchBox.click();
		searchBox.sendKeys("iphone xr 64gb yellow", Keys.ENTER);
		Thread.sleep(2000);

		driver1.findElement(By.xpath("//div[text()='Apple iPhone XR (Yellow, 64 GB)']")).click();

		Set<String> wHandles = driver1.getWindowHandles();
		String currentHandle = driver1.getWindowHandle();
		System.out.println("Current handle is " + currentHandle);
		System.out.println("List of current handles " + wHandles);
		wHandles.remove(currentHandle);
		String flipHandle = wHandles.iterator().next();
		driver1.switchTo().window(flipHandle);

//		// select the product
		Thread.sleep(3000L);
		String priceXPath = "//img[@id='price-info-icon']/../preceding-sibling::div";
		WebElement flipPriceWe = driver1.findElement(By.xpath(priceXPath));
		System.out.println(flipPriceWe.getText());
	}

}
