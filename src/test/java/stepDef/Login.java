package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends env_target {
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        // Maximize Driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // Set URL
        driver.get(baseUrl);
        // Duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type=\"submit\"][@id=\"login-button\"]")));
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@id='login-button']")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        // Duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='product_label'][contains(text(), 'Products')]")));
        driver.quit();
    }

    @When("User invalid fill username and password")
    public void userInvalidFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        // Duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h3[data-test='error']")));
        driver.quit();
    }

    @When("^User input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User get Verify login (.*)$")
    public void userGetVerifyLoginResults(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        if (result.equals("Passed")) {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@class='product_label'][contains(text(), 'Products')]")));
        } else if (result.equals("Failed")) {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h3[@data-test='error']")));
        }
        driver.quit();
    }
}
