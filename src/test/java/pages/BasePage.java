package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.wait = driverWait;
    }

    public WebDriver getDriver() {
            return driver;
        }

    public WebDriverWait getDriverWait() {
            return wait;
        }
}
