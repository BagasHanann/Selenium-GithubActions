package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver) {
        this.driver = driver;
    }

    // locator firstname and lastname
    By firstName = By.id("customer.firstName");
    By lastName = By.name("customer.lastName");

    public void inputUser(String firstname, String lastname) {
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void userInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(), 'Signing up is easy!')]")));
    }

}
