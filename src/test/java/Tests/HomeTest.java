package Tests;

import org.testng.annotations.Test;
import pageObjects.HomePageObjects;

@Test
public class HomeTest {
    HomePageObjects homePageObjects = new HomePageObjects();
    public void clickMenu(){
        homePageObjects.clickOnSideMenu("Dashboard");
    }
    public void clickSubMenu(){
        homePageObjects.clickOnSideSubMenu(true,"Users");
    }
}
