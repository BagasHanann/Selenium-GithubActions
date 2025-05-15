package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.homePages;
import pages.registerPages;
import pages.addressPages;
import pages.credentialsPages;
import pages.validationPages;

import java.time.Duration;
import java.util.Random;

public class MyStepdefs extends env_target {

    registerPages registerPage;
    credentialsPages credentialPage;
    homePages homePage;
    addressPages addressPage;
    validationPages validationPage;

    @Given("^User on ParaBank homepage$")
    public void userOnParaBankHomepage() {
        // Set driver location path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        // Maximize Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Set URL
        String paraBankLink = "https://parabank.parasoft.com/parabank/register.htm?ConnType=JDBC";
        driver.get(paraBankLink);
        // Duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='leftPanel']/h2")));

        registerPage = new registerPages(driver);
        credentialPage = new credentialsPages(driver);
        homePage = new homePages(driver);
        addressPage = new addressPages(driver);
        validationPage = new validationPages(driver);
    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        homePage.clickRegister();
    }

    @Then("^User is in register page$")
    public void userIsInRegisterPage() {
        registerPage.userInRegisterPage();
    }

    @When("^User input name$")
    public void userInputName() {
        registerPage.inputUser("Bagas", "Keren");
    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        addressPage.inputAddress("Jl. Raya", "Jakarta", "DKI Jakarta", "12345", "08123456789", "123456789");
    }

    @And("^user fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        credentialPage.inputUsernamePassword("user" + userRand, "12345");
    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        credentialPage.inputConfirmPassword("12345");
    }

    @When("^User click register button$")
    public void userClickRegisterButton() {
        credentialPage.clickRegisterButton();
    }

    @Then("^User register successfully$")
    public void userRegisterSuccessfully() {
        validationPage.validateSuccessRegistration();
        driver.quit();
    }

    @And("^User input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        credentialPage.inputConfirmPassword("11111");
    }

    @Then("^User set error password did not match$")
    public void userSetErrorPasswordDidNotMatch() {
        validationPage.validatePasswordMismatchError();
        driver.quit();
    }
}
