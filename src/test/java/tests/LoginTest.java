package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement((By.xpath("//input[@data-test ='login-button']"))).click();
        String title = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectedLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement((By.xpath("//input[@data-test ='login-button']"))).click();
        boolean isAppear = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();
        assertTrue(isAppear, "Not appear this window with massage");
        String isErrorMsgDisplayed = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        assertEquals(isErrorMsgDisplayed, "Epic sadface: Sorry, this user has been locked out.");
    }
}
