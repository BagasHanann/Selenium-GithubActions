package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class credentialsPages {
    WebDriver driver;

    public credentialsPages(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By usernameField = By.id("customer.username");
    By passwordField = By.id("customer.password");
    By confirmPasswordField = By.id("repeatedPassword");
    By registerButton = By.xpath("//input[@class='button'][@value='Register']");

    // Actions
    public void inputUsernamePassword(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
