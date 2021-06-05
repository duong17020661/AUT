package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import pageObjects.UsersPageObjects;
import reusableComponents.ExcelOperations;
import testBase.ExtentFactory;
import testBase.TestBase;

import java.util.HashMap;

public class TestCase extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	UsersPageObjects userPage = new UsersPageObjects();

	ExcelOperations excel = new ExcelOperations("TaskCreationData");
	
	@Test(dataProvider = "taskCreationData")
	public void UserCreationTest(Object obj1) throws Throwable {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		ExtentFactory.getInstance().getExtent().info("Dữ liệu người dùng: "+ testData);

		loginPage.login("admin@localhost.com", "11111111");
		userPage.createUser(testData);
		userPage.Search_Verify_UserCreationOnUI(testData.get("Fullname"),testData.get("Email"));
		userPage.checkUserInDatabase(testData.get("Email"), true);
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
