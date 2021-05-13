import org.openqa.selenium.WebDriver;

public interface DriverManagerObject {
    WebDriver getDriverManager(WebDriver driverManager);
}
class   Chorme implements DriverManagerObject {
    @Override
    public WebDriver getDriverManager(WebDriver driverManager) {
        return driverManager;
    }
}
class Firefox implements DriverManagerObject {
    @Override
    public WebDriver getDriverManager(WebDriver driverManager) {
        return driverManager;
    }
}
class IE implements DriverManagerObject {
    @Override
    public WebDriver getDriverManager(WebDriver driverManager) {
        return driverManager;
    }
}

class DriverManagerFactory {
    public void getDriverManager(String browser) {
        DriverManagerObject driverManagerObject;
        WebDriver driverManager = null;
        if (browser.equalsIgnoreCase("Chrome")) {
            driverManagerObject = new Chorme();
            driverManagerObject.getDriverManager(driverManager);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driverManagerObject = new Firefox();
            driverManagerObject.getDriverManager(driverManager);
        } else if (browser.equalsIgnoreCase("IE")) {
            driverManagerObject = new IE()  ;
            driverManagerObject.getDriverManager(driverManager);
        }
    }
}