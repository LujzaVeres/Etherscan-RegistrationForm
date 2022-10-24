package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationFormPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected RegistrationFormPage registrationFormPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        registrationFormPage = new RegistrationFormPage(driver,wait);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://etherscan.io/register");
    }

    @Test
    public void registrationPageAssert(){
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/register"));
        Assert.assertEquals(registrationFormPage.getRegistrationPageTitle().getText(), "Register a New Account");
    }

    @Test
    public void registrationFormAssert(){
        Assert.assertEquals(registrationFormPage.getRegistrationPageTitle().getText(), "Register a New Account");
        Assert.assertEquals(registrationFormPage.getUsernameField().getText(), "Username");
        Assert.assertEquals(registrationFormPage.getEmailAddressField().getText(), "Email Address");
        Assert.assertEquals(registrationFormPage.getConfirmEmailAddressField().getText(), "Confirm Email Address");
        Assert.assertEquals(registrationFormPage.getPasswordField().getText(), "Password");
        Assert.assertEquals(registrationFormPage.getConfirmPasswordField().getText(), "Confirm Password");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        wait.until(ExpectedConditions.visibilityOf(registrationFormPage.getTermsAndConditionsCheckBox()));
        Assert.assertEquals(registrationFormPage.getTermsAndConditionsCheckBox().getText(), "Terms and Conditions");
        Assert.assertEquals(registrationFormPage.getNewsletterCheckBox().getText(), "I agree to receive the Etherscan newsletter and understand that I can unsubscribe at any time.");
        Assert.assertEquals(registrationFormPage.getSubmitButton().getAttribute("value"), "Create an Account");
        Assert.assertEquals(registrationFormPage.getSignInButton().getText(), "Click to Sign In");
    }

    @Test
    public void registrationValidInput() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaVeres", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        wait.until(ExpectedConditions.visibilityOf(registrationFormPage.getSuccessfulRegMsg()));
        Assert.assertEquals(registrationFormPage.getSuccessfulRegMsg().getText(), "Your account registration has been submitted and is pending email verification");
    }

    @Test
    public void registrationWithoutCheckingSubscription() throws InterruptedException {
        registrationFormPage.doNotCheckSubscription("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        wait.until(ExpectedConditions.visibilityOf(registrationFormPage.getSuccessfulRegMsg()));
        Assert.assertEquals(registrationFormPage.getSuccessfulRegMsg().getText(), "Your account registration has been submitted and is pending email verification");
    }

    @Test
    public void registrationWithoutFillingInput(){
        registrationFormPage.withoutFillingInput();
        Assert.assertEquals(registrationFormPage.getErrorUsername().getText(), "Username is invalid.");
        Assert.assertEquals(registrationFormPage.getErrorEmail().getText(), "Please enter a valid email address.");
        Assert.assertEquals(registrationFormPage.getErrorConfirmEmail().getText(), "Please re-enter your email address.");
        Assert.assertEquals(registrationFormPage.getErrorPassword().getText(), "Your password must be at least 5 characters long.");
        Assert.assertEquals(registrationFormPage.getErrorConfirmPassword().getText(), "Your password must be at least 5 characters long.");
        Assert.assertEquals(registrationFormPage.getErrorTermsAndCond().getText(), "Please accept our Terms and Conditions.");
    }

    @Test
    public void registrationUsernameLessThenFiveCharacters() throws InterruptedException {
        registrationFormPage.fillValidCredentials("Luki", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorUsername().getText(), "Username is invalid.");
    }

    @Test
    public void assertUsernameMoreThenThirtyCharacters() throws InterruptedException {
        registrationFormPage.getUserName().sendKeys("LllluuuujjjjzzzaaaaVeeeereeeess");
        String value = registrationFormPage.getUserName().getAttribute("value");
        int size = value.length();
        if (size == 30) {
            System.out.println("Max character is 30.");
        }
        else {
            System.out.println("No limit.");
        }
    }

    @Test
    public void registrationWithExistingUsername() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaVeres", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorUsernameExist().getText(), "Sorry! The username you entered is already in use.");
    }

    @Test
    public void registrationWithNonAlphanumericUsername() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaV!!!", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorUsername().getText(), "Username is invalid.");
    }

    @Test
    public void registrationWithoutUsername() throws InterruptedException {
        registrationFormPage.withoutUsername("lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorUsername().getText(), "Username is invalid.");
    }

    @Test
    public void registrationWithInvalidEmail() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaVeresV", "lujzav@stt.c", "lujzav@stt.c", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorInvalidEmailFormat().getText(), "Invalid email format. lujzav@stt.c");
    }

    @Test
    public void registrationWithoutEmail() throws InterruptedException {
        registrationFormPage.fwithoutEmail("LujzaVeresV", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorEmail().getText(), "Please enter a valid email address.");
        Assert.assertEquals(registrationFormPage.getErrorConfirmEmail().getText(), "Please re-enter your email address.");
    }

    @Test
    public void registrationWithEmailNotMatching() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaV", "lujzav@yahoo.com", "luki@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getEmailDoNotMatch().getText(), "Email address does not match.");
    }

    @Test
    public void registrationWithShortPassword() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com", "lujza", "lujza");
        Assert.assertEquals(registrationFormPage.getPasswordTooShort().getText(), "Password too short. Minimum of 6 characters required");
    }

    @Test
    public void registrationWithoutPassword() throws InterruptedException {
        registrationFormPage.withoutPassword("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com");
        Assert.assertEquals(registrationFormPage.getErrorPassword().getText(), "Your password must be at least 5 characters long.");
        Assert.assertEquals(registrationFormPage.getErrorConfirmPassword().getText(), "Your password must be at least 5 characters long.");
    }

    @Test
    public void registrationWithPasswordNotMatching() throws InterruptedException {
        registrationFormPage.fillValidCredentials("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "kursevi");
        Assert.assertEquals(registrationFormPage.getPasswordDoNotMatch().getText(), "Password does not match, please check again.");
    }

    @Test
    public void registrationWithoutCheckingTermsAndConds() throws InterruptedException {
        registrationFormPage.doNotCheckTermsAndConds("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getExceptTermsAndConds().getText(), "Please accept our Terms and Conditions.");
    }

    @Test
    public void registrationWithoutCheckingReCaptcha() throws InterruptedException {
        registrationFormPage.doNotCheckReCaptcha("LujzaV", "lujzav@yahoo.com", "lujzav@yahoo.com", "Kursevi1", "Kursevi1");
        Assert.assertEquals(registrationFormPage.getErrorReCaptcha().getText(), "Error! Invalid captcha response.\n" +
                "Please Try Again");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
