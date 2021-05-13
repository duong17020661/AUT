package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class UsersPageObjects extends TestBase{
	
	By btn_addUser = By.xpath("//button[normalize-space()='Add User']");
	By chk_Active = By.id("users_active");
	By dd_group = By.id("users_users_group_id");
	By txt_FullName = By.name("users[name]");
	By txt_Password = By.name("users[password]");
	By txt_Email = By.name("users[email]");
	By txt_Phone = By.name("extra_fields[9]");
	By btn_UserPhoto = By.id("users_photo");
	By btn_Save = By.id("submit_button");

    public void createUser(HashMap<String, String> testData) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_addUser), "Add User");
		selectedCheckbox_custom(DriverFactory.getInstance().getDriver().findElement(chk_Active), "Active", Integer.parseInt(testData.get("Active")));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_group), "Add Group", testData.get("Group"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_FullName), "Add FullName", testData.get("FullName"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Email), "Add Email", testData.get("Email"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Password), "Add Password", testData.get("Password"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Phone), "Add Phone", testData.get("Phone"));
		uploadFile_custom(DriverFactory.getInstance().getDriver().findElement(btn_UserPhoto), "Add Photo", testData.get("Photo"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(btn_addUser), "Add Language", testData.get("Language"));
		Thread.sleep(2000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Save), "NewUserCreated");
    }

	public void Search_Verify_UserCreationOnUI(HashMap<String, String> testData) {
	}
}
