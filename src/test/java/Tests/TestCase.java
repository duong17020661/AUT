package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UsersPageObjects;
import reusableComponents.DB_Operations;
import reusableComponents.ExcelOperations;
import testBase.ExtentFactory;
import testBase.TestBase;

import java.util.HashMap;

/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */

public class TestCase extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	UsersPageObjects userPage = new UsersPageObjects();
	DB_Operations dbOps = new DB_Operations();

	ExcelOperations excel = new ExcelOperations("TaskCreationData");
	
	@Test(dataProvider = "taskCreationData")
	public void UserCreationTest(Object obj1) throws Throwable {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		ExtentFactory.getInstance().getExtent().info("Dữ liệu người dùng: "+ testData);

		loginPage.login("admin@localhost.com", "11111111");
		homePage.clickOnSideSubMenu(true, "Add User");
		userPage.createUser(testData);
		userPage.Search_Verify_UserCreationOnUI(testData);

		String sql = "SELECT * FROM `users` where name = '"+testData.get("Email")+"'";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		String Email = dbData.get("email");
		assertEqualsString_custom("Không tìm thầy người dùng", Email, "Users");
	}

	@DataProvider (name = "taskCreationData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
	}
}
