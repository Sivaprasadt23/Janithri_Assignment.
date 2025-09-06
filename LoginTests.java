package tests;

import base.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import org.testng.Assert;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty(){
     
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedbutton(){
        loginPage.enterPassword("MySecret123");
        String typeBefore = loginPage.getPasswordFieldType();
     
        loginPage.togglePasswordVisibility();
        String typeAfter = loginPage.getPasswordFieldType();
        Assert.assertNotEquals(typeBefore, typeAfter, "Password field type should change after toggling visibility");
    }

    @Test
    public void testInvalidLoginShowErrorMsg(){
        loginPage.enterUserId("randomuser");
        loginPage.enterPassword("randompass");
        loginPage.clickLogin();
       
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login") || currentUrl.contains("error"), "Invalid login should not redirect to dashboard");
    }
}
