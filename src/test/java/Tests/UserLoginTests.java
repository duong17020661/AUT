package Tests;

import cucumber.api.java.en.When;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import testBase.TestBase;

@Test
public class UserLoginTests extends TestBase{
	LoginPageObjects loginPage = new LoginPageObjects();

	@When("^Enter the Username \"(.*)\" and Password \"(.*)\"$")
	public void ManagerLoginTest() throws Throwable {

		loginPage.login("admin@localhost.com", "1111111");
		Thread.sleep(2000);

	}
	public void ClientLoginTest() throws Throwable {

		loginPage.login("admin@localhost.com", "11111111");
		Thread.sleep(2000);

	}
	public void DesignerLoginTest() throws Throwable {

		loginPage.login("admin@localhost.com", "11111111");
		Thread.sleep(2000);
	}

}
