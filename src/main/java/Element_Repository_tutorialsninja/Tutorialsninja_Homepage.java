package Element_Repository_tutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tutorialsninja_Homepage {
	WebDriver driver;
//Declaration
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement Myaccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement Login;
//Initilisaton

	public Tutorialsninja_Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Utilisation
	public void Myaccount_Select_dropdown() {
		Myaccount.click();
	}

	public void Login_Click() {
		Login.click();
	}
}
