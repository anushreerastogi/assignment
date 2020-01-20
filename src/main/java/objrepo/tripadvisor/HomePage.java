package objrepo.tripadvisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private String url = "https://www.tripadvisor.in/";

	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchBtn;

	@FindBy(id = "mainSearch")
	private WebElement mainSearch;

	public void openPage(WebDriver wd) {
		wd.get(this.url);
	}

	public void search(String searchText) throws InterruptedException {
		this.searchBtn.click();
		Thread.sleep(2000L);
		this.mainSearch.sendKeys(searchText);
	}
}
