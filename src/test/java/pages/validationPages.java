package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class validationPages {
    WebDriver driver;

    public validationPages(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By successMessage = By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]");
    By passwordErrorMessage = By.xpath("//*[contains(text(), 'Passwords did not match.')]");

    // Actions to validate success message
    public void validateSuccessRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    // Actions to validate password mismatch error
    public void validatePasswordMismatchError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorMessage));
    }
}
