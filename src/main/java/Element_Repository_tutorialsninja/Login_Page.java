package Element_Repository_tutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver;
	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement login;

	// Initilisation
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login_button() {
		login.click();
	}

	public void email_textfield(String Email) {
		email.sendKeys(Email);
	}

	public void password_textfield(String Password) {
		password.sendKeys(Password);
	}
}
