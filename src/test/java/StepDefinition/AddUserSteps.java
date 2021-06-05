package StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import pageObjects.UsersPageObjects;
import testBase.TestBase;

public class AddUserSteps {
    UsersPageObjects userPage = new UsersPageObjects();
    TestBase testBase = new TestBase();
    LoginPageObjects loginPage = new LoginPageObjects();
    @Given("^navigate to web$")
    public void navigate_to_web() throws Throwable {
        testBase.LaunchApplication();
    }
    @When("^sign in$")
    public void sign_in() throws Throwable {
        loginPage.login("admin@localhost.com", "11111111");
    }
    @Then("^click add user button$")
    public void click_add_user_button() throws Throwable {
        userPage.clickButtonAddUser();
    }
    @When("^user check user active: (.*)$")
    public void user_check_user_active(String checked) throws Throwable {
        if (checked == "checked") {
            userPage.checkActive(1);
        }
        else userPage.checkActive(0);

    }
    @When("^user select Group (.*) and Language (.*)$")
    public void user_select_Group_and_Language(String group, String language) throws Throwable {
        userPage.selectDropdown(group,language);
    }
    @When("^user choose a photo have url (.*)$")
    public void user_choose_a_photo_have_url(String url) throws Throwable {
        userPage.uploadFile(url);
    }
    @When("^user enters Fullname (.*) Email (.*) Password (.*) Phone (.*)$")
    public void user_enters_Fullname_Email_Password_Phone(String fullname,String email,String password,String phone) throws Throwable {
        userPage.addInfomation(fullname,email, password, phone);
    }
    @When("^user click button to add new user$")
    public void user_click_button_to_add_new_user() throws Throwable {
        userPage.addUser();
    }
    @When("^check user have name (.*) and email (.*) in table$")
    public void check_user_have_name_and_email_in_table(String name, String email) throws Throwable {
        userPage.Search_Verify_UserCreationOnUI(name, email);
    }
    @Then("^check user (.*) created in database$")
    public void check_user_created_in_database(String email) throws Throwable {
        userPage.checkUserInDatabase(email, true);
    }
    @Then("^check user (.*) already exists in database$")
    public void check_user_already_exists_in_database(String email) throws Throwable {
        userPage.checkUserInDatabase(email, false);
    }
}
