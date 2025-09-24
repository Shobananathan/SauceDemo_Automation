package ACME_Demo_Banking.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankLoginPage {
    WebDriver driver;
    @FindBy(id = "username")
    WebElement input_username;
    @FindBy(id = "password")
    WebElement input_password;
    @FindBy(id = "log-in")
    WebElement btn_login;

    public BankLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(input_username));
        wait.until(ExpectedConditions.visibilityOf(input_password));
        wait.until(ExpectedConditions.visibilityOf(btn_login));

        input_username.clear();
        input_username.sendKeys(username);

        input_password.clear();
        input_password.sendKeys(password);

        btn_login.click();
    }
}
