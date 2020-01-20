package objrepo.tripadvisor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailPage {

	@FindBy(xpath = "//a[@class='ui_button primary']")
	private WebElement reviewButton;

	public void review() {
		this.reviewButton.click();
	}
}
