package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

   
    private By userIdInput = By.id("username"); // update to actual locator
    private By passwordInput = By.id("password"); // update to actual locator
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By eyeIcon = By.cssSelector(".password-eye"); // update to actual locator
    private By pageTitle = By.tagName("h1");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserIdInput(){ return driver.findElement(userIdInput); }
    public WebElement getPasswordInput(){ return driver.findElement(passwordInput); }
    public WebElement getLoginButton(){ return driver.findElement(loginButton); }
    public WebElement getEyeIcon(){ return driver.findElement(eyeIcon); }
    public String getTitleText(){ return driver.findElement(pageTitle).getText(); }

    public boolean isLoginButtonEnabled(){
        return getLoginButton().isEnabled();
    }

    public void enterUserId(String uid){
        getUserIdInput().clear();
        getUserIdInput().sendKeys(uid);
    }

    public void enterPassword(String pwd){
        getPasswordInput().clear();
        getPasswordInput().sendKeys(pwd);
    }

    public void clickLogin(){
        getLoginButton().click();
    }

    public void togglePasswordVisibility(){
        getEyeIcon().click();
    }

    public String getPasswordFieldType(){
        return getPasswordInput().getAttribute("type");
    }
}
