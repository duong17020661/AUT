package pageObjects;


import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import org.testng.Assert;
import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase  {
	By EMAIL = By.name("login[email]");
	By PASSWORD = By.name("login[password]");
	By LOGIN_BTN = By.xpath("//button[@type='submit']");
	By USER_SETTING = By.xpath("//span[@class='username']");

	public void login(String email, String password) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(EMAIL), "LoginEmailFIeld", email);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "LoginPasswordFIeld", password);
		click_custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN), "LoginButton");
		String name = getText_custom(DriverFactory.getInstance().getDriver().findElement(USER_SETTING),"Dropdown Setting");
		Assert.assertTrue(name == email);
	}
}


