package pageObjects;

import java.util.HashMap;

import gherkin.lexer.Th;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reusableComponents.DB_Operations;
import testBase.DriverFactory;
import testBase.TestBase;

public class UsersPageObjects extends TestBase{
	
	By btn_addUser = By.xpath("//button[normalize-space()='Add User']");
	By chk_Active = By.xpath("//*[@id=\"users_active\"]");
	By chk_Element_Active = By.xpath("//*[@id=\"uniform-users_active\"]");
	By dd_group = By.xpath("//*[@id=\"users_users_group_id\"]");
	By txt_FullName = By.name("users[name]");
	By txt_Password = By.name("users[password]");
	By txt_Email = By.name("users[email]");
	By txt_Phone = By.name("extra_fields[9]");
	By btn_UserPhoto = By.xpath("//*[@id=\"users_photo\"]");
	By dd_language = By.xpath("//*[@id=\"users_culture\"]");
	By btn_Save = By.id("submit_button");
	By field_Search = By.xpath("//*[@id=\"search_menu\"]");
	By txt_Search = By.xpath("//input[@id='search_keywords']");
	By btn_Search = By.xpath("//input[@value='Search']");
	DB_Operations dbOps = new DB_Operations();
	int totalCount;
	public void createUser(HashMap<String, String> testData) throws Throwable {
		String queryTotal = "SELECT COUNT(*) as total FROM `users`";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(queryTotal);
		totalCount = Integer.parseInt(dbData.get("total"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_addUser), "Add User");
		Thread.sleep(300);
		selectedCheckbox_custom(DriverFactory.getInstance().getDriver().findElement(chk_Active), DriverFactory.getInstance().getDriver().findElement(chk_Element_Active),"Active", Integer.parseInt(testData.get("Active")));
		Thread.sleep(300);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_group), "Add Group", testData.get("Group"));
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_FullName), "Add FullName", testData.get("FullName"));
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Email), "Add Email", testData.get("Email"));
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Password), "Add Password", testData.get("Password"));
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Phone), "Add Phone", testData.get("Phone"));
		Thread.sleep(300);
		uploadFile_custom(DriverFactory.getInstance().getDriver().findElement(btn_UserPhoto), "Add Photo", testData.get("Photo"));
		Thread.sleep(300);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_language), "Add Language", testData.get("Language"));
		Thread.sleep(300);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Save), "NewUserCreated");
    }

    public void clickButtonAddUser() throws Throwable {
		String queryTotal = "SELECT COUNT(*) as total FROM `users`";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(queryTotal);
		totalCount = Integer.parseInt(dbData.get("total"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_addUser), "Add User");
		Thread.sleep(300);
	}

	public void checkActive(int active) throws Throwable {
		selectedCheckbox_custom(DriverFactory.getInstance().getDriver().findElement(chk_Active), DriverFactory.getInstance().getDriver().findElement(chk_Element_Active),"Active", active);
		Thread.sleep(300);
    }
	public void selectDropdown(String group, String language) throws Throwable{
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_group), "Add Group", group);
		Thread.sleep(300);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_language), "Add Language", language);
		Thread.sleep(300);
    }
	public void uploadFile(String url) throws Throwable {
		uploadFile_custom(DriverFactory.getInstance().getDriver().findElement(btn_UserPhoto), "Add Photo", url);
		Thread.sleep(300);
    }
	public void addInfomation(String fullname,String email,String password,String phone) throws Throwable{
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_FullName), "Add FullName", fullname);
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Email), "Add Email", email);
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Password), "Add Password", password);
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Phone), "Add Phone", phone);
		Thread.sleep(300);
    }

	public void addUser() throws Throwable{
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Save), "NewUserCreated");
	}

	public void Search_Verify_UserCreationOnUI(String name, String email) throws Throwable {
		moveToElement_custom(DriverFactory.getInstance().getDriver().findElement(field_Search), "TaskSearchOption");
		Thread.sleep(300);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Search), "TaskSearchBox", name);
		Thread.sleep(300);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Search), "SearchButton");
		Thread.sleep(300);
		findUserInTable(email);
	}

	private void findUserInTable(String email) {
		try {
			int i = 1;
			boolean find = false;
			String valueXpath;
			while (!find) {
				valueXpath = "//*[@id=\"table-users\"]/tbody/tr[" + i + "]/td[7]";
				String value = DriverFactory.getInstance().getDriver().findElement(By.xpath(valueXpath)).getText();
				if (value.equals(email) == true) {
					find = true;
				}
				i++;
			}
		}
		catch (Exception e){

		}
		finally {

		}
	}

	public void checkUserInDatabase(String emailUser, boolean created) throws Throwable{
		String queryEmail = "SELECT * FROM `users` where email = '"+emailUser+"'";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(queryEmail);
		String email = dbData.get("email");
		String queryTotal = "SELECT COUNT(*) as total FROM `users`";
		HashMap<String, String> totalData = dbOps.getSqlResultInMap(queryTotal);
		int total = Integer.parseInt(totalData.get("total"));
		if(total != totalCount + 1 || email.length() == 0){
			Assert.assertTrue(!created);
		}
		else {
			Assert.assertTrue(created);
		}
	}
}
