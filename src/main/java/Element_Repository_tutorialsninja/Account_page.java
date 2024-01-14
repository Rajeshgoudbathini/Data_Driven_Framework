package Element_Repository_tutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_page {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement edityouraccountinformation;

	public Account_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Edityouraccountinformation() {
		edityouraccountinformation.click();
	}

	public boolean verify_Edityouraccountinformation() {
		boolean actual = false;

		try {
			actual = edityouraccountinformation.isDisplayed();
		} catch (Exception e) {
			actual = false;
		}
		return actual;
	}
}
