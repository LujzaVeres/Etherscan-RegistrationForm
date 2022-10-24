package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFormPage extends BasePage {
    protected By registrationPageTitle = By.xpath("//*[@id='ctl00']/div[3]/h1");
    protected By usernameField = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[1]/label");
    protected By emailAddressField = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[2]/label");
    protected By confirmEmailAddressField = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[3]/label");
    protected By passwordField = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[4]/div[1]/div/label");
    protected By confirmPasswordField = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[4]/div[2]/div/label");
    protected By termsAndConditionsCheckBox = By.className("link-muted");
    protected By newsletterCheckBox = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[6]/div/label");
    protected By submitButton = By.xpath("//*[@id='ContentPlaceHolder1_btnRegister']");
    protected By signInButton = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[8]/div[1]/a");
    protected By userName = By.id("ContentPlaceHolder1_txtUserName");
    protected By emailAddress = By.id("ContentPlaceHolder1_txtEmail");
    protected By confirmEmail = By.id("ContentPlaceHolder1_txtConfirmEmail");
    protected By password = By.id("ContentPlaceHolder1_txtPassword");
    protected By confirmPassword = By.id("ContentPlaceHolder1_txtPassword2");
    protected By termsAndConds = By.xpath("//*[@id='ContentPlaceHolder1_maindiv']/div[5]/div/label/span");
    protected By newsletter = By.cssSelector("label[for='ContentPlaceHolder1_SubscribeNewsletter']");
    protected By submit = By.xpath("//*[@id='ContentPlaceHolder1_btnRegister']");
    protected By successfulRegMsg = By.xpath("//*[@id='ctl00']/div[4]");
    protected By errorUsername = By.id("ContentPlaceHolder1_txtUserName-error");
    protected By errorEmail = By.id("ContentPlaceHolder1_txtEmail-error");
    protected By errorConfirmEmail = By.id("ContentPlaceHolder1_txtConfirmEmail-error");
    protected By errorPassword = By.id("ContentPlaceHolder1_txtPassword-error");
    protected By errorConfirmPassword = By.id("ContentPlaceHolder1_txtPassword2-error");
    protected By errorTermsAndCond = By.id("ctl00$ContentPlaceHolder1$MyCheckBox-error");
    protected By errorUsernameExist = By.xpath("//*[@id='ctl00']/div[4]");
    protected By errorInvalidEmailFormat = By.xpath("//*[@id='ctl00']/div[4]");
    protected By emailDoNotMatch = By.id("ContentPlaceHolder1_txtConfirmEmail-error");
    protected By passwordTooShort = By.xpath("//*[@id='ctl00']/div[4]");
    protected By passwordDoNotMatch = By.id("ContentPlaceHolder1_txtPassword2-error");
    protected By exceptTermsAndConds = By.id("ctl00$ContentPlaceHolder1$MyCheckBox-error");
    protected By errorReCaptcha = By.xpath("//*[@id='ctl00']/div[4]");


    public RegistrationFormPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getRegistrationPageTitle() {
        return getDriver().findElement(registrationPageTitle);
    }

    public WebElement getUsernameField() {
        return getDriver().findElement(usernameField);
    }

    public WebElement getEmailAddressField() {
        return getDriver().findElement(emailAddressField);
    }

    public WebElement getConfirmEmailAddressField() {
        return getDriver().findElement(confirmEmailAddressField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getTermsAndConditionsCheckBox() {
        return getDriver().findElement(termsAndConditionsCheckBox);
    }

    public WebElement getNewsletterCheckBox() {
        return getDriver().findElement(newsletterCheckBox);
    }

    public WebElement getSubmitButton() {
        return getDriver().findElement(submitButton);
    }

    public WebElement getSignInButton() {
        return getDriver().findElement(signInButton);
    }

    public WebElement getUserName() {
        return getDriver().findElement(userName);
    }

    public WebElement getEmailAddress() {
        return getDriver().findElement(emailAddress);
    }

    public WebElement getConfirmEmail() {
        return getDriver().findElement(confirmEmail);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getTermsAndConds() {
        return getDriver().findElement(termsAndConds);
    }

    public WebElement getNewsletter() {
        return getDriver().findElement(newsletter);
    }

    public WebElement getSubmit() {
        return getDriver().findElement(submit);
    }

    public WebElement getSuccessfulRegMsg() {
        return getDriver().findElement(successfulRegMsg);
    }

    public WebElement getErrorUsername() {
        return getDriver().findElement(errorUsername);
    }

    public WebElement getErrorEmail() {
        return getDriver().findElement(errorEmail);
    }

    public WebElement getErrorConfirmEmail() {
        return getDriver().findElement(errorConfirmEmail);
    }

    public WebElement getErrorPassword() {
        return getDriver().findElement(errorPassword);
    }

    public WebElement getErrorConfirmPassword() {
        return getDriver().findElement(errorConfirmPassword);
    }

    public WebElement getErrorTermsAndCond() {
        return getDriver().findElement(errorTermsAndCond);
    }

    public WebElement getErrorUsernameExist() {
        return getDriver().findElement(errorUsernameExist);
    }

    public WebElement getErrorInvalidEmailFormat() {
        return getDriver().findElement(errorInvalidEmailFormat);
    }

    public WebElement getEmailDoNotMatch() {
        return getDriver().findElement(emailDoNotMatch);
    }

    public WebElement getPasswordTooShort() {
        return getDriver().findElement(passwordTooShort);
    }

    public WebElement getPasswordDoNotMatch() {
        return getDriver().findElement(passwordDoNotMatch);
    }

    public WebElement getExceptTermsAndConds() {
        return getDriver().findElement(exceptTermsAndConds);
    }

    public WebElement getErrorReCaptcha() {
        return getDriver().findElement(errorReCaptcha);
    }

    public void clickOnReCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[(@title='reCAPTCHA')]")));
        WebElement reCaptcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[id='recaptcha-anchor']")));
        reCaptcha.click();
        driver.switchTo().defaultContent();
    }

    public void fillValidCredentials(String username, String email, String confirmEmail, String password, String confirmPassword) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        getNewsletter().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void doNotCheckSubscription(String username, String email, String confirmEmail, String password, String confirmPassword) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void withoutFillingInput(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getSubmit().click();
    }

    public void withoutUsername(String email, String confirmEmail, String password, String confirmPassword) throws InterruptedException {
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        getNewsletter().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void fwithoutEmail(String username, String password, String confirmPassword) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        getNewsletter().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void withoutPassword(String username, String email, String confirmEmail) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        getNewsletter().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void doNotCheckTermsAndConds(String username, String email, String confirmEmail, String password, String confirmPassword) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getNewsletter().click();
        clickOnReCaptcha();
        Thread.sleep(7000);
        getSubmit().click();
    }

    public void doNotCheckReCaptcha(String username, String email, String confirmEmail, String password, String confirmPassword) throws InterruptedException {
        getUserName().click();
        getUserName().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getUserName().sendKeys(username);
        getEmailAddress().click();
        getEmailAddress().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEmailAddress().sendKeys(email);
        getConfirmEmail().click();
        getConfirmEmail().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmEmail().sendKeys(confirmEmail);
        getPassword().click();
        getPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getConfirmPassword().sendKeys(confirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        getTermsAndConds().click();
        getNewsletter().click();
        getSubmit().click();
    }
}


