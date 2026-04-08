package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkUncorrectedLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorMsgDisplayed(), "Error message not appear.");
        assertEquals(loginPage.getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkEmptyUserLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorMsgDisplayed(), "Error message not appear");
        assertEquals(loginPage.getErrorMsg(), "Epic sadface: Username is required");
    }
}
