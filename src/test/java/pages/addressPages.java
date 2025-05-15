package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addressPages {
    WebDriver driver;

    public addressPages(WebDriver driver) {
      this.driver = driver;
    }

    By addressStreet = By.id("customer.address.street");
    By addressCity = By.id("customer.address.city");
    By addressState = By.id("customer.address.state");
    By addressZipCode = By.id("customer.address.zipCode");
    By addressPhoneNumber = By.id("customer.phoneNumber");
    By addressSSN = By.id("customer.ssn");

    public void inputAddress(String street, String city, String state, String zipCode, String phoneNumber, String ssn) {
      driver.findElement(addressStreet).sendKeys(street);
      driver.findElement(addressCity).sendKeys(city);
      driver.findElement(addressState).sendKeys(state);
      driver.findElement(addressZipCode).sendKeys(zipCode);
      driver.findElement(addressPhoneNumber).sendKeys(phoneNumber);
      driver.findElement(addressSSN).sendKeys(ssn);
    }
}
