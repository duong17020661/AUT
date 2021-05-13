import org.openqa.selenium.WebDriver;

public class UseTest {
    WebDriver driverManager;
    public void getChromeDriver() {
        Chorme chorme = new Chorme();
        chorme.getDriverManager(driverManager);
    }

    public void getFirefox() {
        Firefox firefox = new Firefox();
        firefox.getDriverManager(driverManager);
    }

    public void getIEDriver(){
        IE ie = new IE();
        ie.getDriverManager(driverManager);
    }

    public void getDriver(){
        DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
        driverManagerFactory.getDriverManager("Chrome");
        driverManagerFactory.getDriverManager("Firefox");
        driverManagerFactory.getDriverManager("IE");
    }
}