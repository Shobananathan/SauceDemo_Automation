package saucedemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {
    WebDriver driver;
    @FindBy(id = "user-name")
    WebElement input_UserName;
    @FindBy(id = "password")
    WebElement input_Password;
    @FindBy(id = "login-button")
    WebElement btn_login;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void loginUser(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(input_UserName));
        wait.until(ExpectedConditions.visibilityOf(input_Password));

        input_UserName.clear();
        input_UserName.sendKeys(username);
        input_Password.clear();
        input_Password.sendKeys(password);
        btn_login.click();


    }
}
