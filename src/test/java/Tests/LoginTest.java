package Tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base_class;
import Element_Repository_tutorialsninja.Account_page;
import Element_Repository_tutorialsninja.Login_Page;
import Element_Repository_tutorialsninja.Tutorialsninja_Homepage;
import util.DataUtil;
import util.MyXLSReader;

public class LoginTest {

	public WebDriver driver;
	MyXLSReader excedata;

	@Test(dataProvider = "provider")
	public void login(HashMap<String, String> hmap) {

		if (!DataUtil.isRunnable(excedata, "LoginTest", "Testcases") || hmap.get("Runmode").equals("N")) {
			throw new SkipException("Runmode set to N ,hence not executed");
		}
		driver = Base_class.browser(hmap.get("Browser"));

		driver.get(Base_class.prop.getProperty("url"));
		Tutorialsninja_Homepage homepage = new Tutorialsninja_Homepage(driver);
		homepage.Myaccount_Select_dropdown();
		homepage.Login_Click();

		Login_Page login_Page = new Login_Page(driver);
		login_Page.email_textfield(hmap.get("Username"));
		login_Page.password_textfield(hmap.get("Password"));
		login_Page.Login_button();

		String expectedresult = hmap.get("ExpectedResult");

		boolean expectedconvertedresult = false;

		if (expectedresult.equalsIgnoreCase("Success")) {
			expectedconvertedresult = true;
		} else if (expectedresult.equalsIgnoreCase("Failure")) {
			expectedconvertedresult = false;
		}

		boolean actual = false;
		Account_page account_page = new Account_page(driver);
		actual = account_page.verify_Edityouraccountinformation();

		Assert.assertEquals(actual, expectedconvertedresult);
	}

	@DataProvider
	public Object[][] provider() {

		Object[][] data = null;
		try {
			excedata = new MyXLSReader("src//test//resources//TutorialsNinja.xlsx");
			data = DataUtil.getTestData(excedata, "LoginTest", "Data");
		} catch (Throwable e) {

			e.printStackTrace();
		}
		return data;
	}
}
