package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase{

	By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");

	public void clickOnSideMenu(String menu) {
		String MenuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(MenuXpath)).click();
	}

	public void clickOnSideSubMenu(Boolean isOpen, String submenu) {
		String submenuXpath="//span[normalize-space()='"+submenu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(submenuXpath)).click();
	}

}
